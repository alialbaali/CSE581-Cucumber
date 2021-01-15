import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

private val driver: WebDriver = setupWebDriver()

const val DefaultUrl = "https://www.saucedemo.com/"
const val InventoryPageUrl = "https://www.saucedemo.com/inventory.html"

const val DefaultUsername = "standard_user"
const val DefaultPassword = "secret_sauce"

fun login(username: String, password: String): String {
    driver.findElement(By.id("user-name")).sendKeys(username)
    driver.findElement(By.id("password")).sendKeys(password)
    driver.findElement(By.id("login-button")).click()
    return if (username.equals(DefaultUsername, true)) "success" else "failure"
}

fun logout() {
    driver.findElement(By.className("bm-burger-button")).click()
    driver.findElement(By.linkText("Logout")).click()
}

fun navigateToItem(index: Int) {
    getInventoryItems()[index]
        .findElement(By.className("inventory_item_img"))
        .click()
}

fun getInventoryItems(): List<WebElement> {
    return driver.findElements(By.className("inventory_item"))
}

fun addCurrentItemToCart() {
    driver.findElement(By.className("btn_inventory")).click()
}

fun navigateToShoppingCart() {
    driver.findElement(By.className("shopping_cart_container")).click()
}

fun shoppingCartIconBadgeCount(): Int = driver.findElement(By.className("shopping_cart_badge")).text.toInt()
fun getShoppingCartItems(): List<WebElement> = driver.findElements(By.className("cart_item"))

fun navigate(page: Page) {
    when (page) {
        is Page.Login -> driver.get(DefaultUrl)
        is Page.Inventory -> login(page.username, page.password)
        is Page.Item -> navigateToItem(page.index)
        is Page.ShoppingCart -> navigateToShoppingCart()
        is Page.Checkout -> navigateToCheckout()
        is Page.FillCheckoutInfo -> fillCheckoutInfo(page.firstName, page.lastName, page.zipCode)
        is Page.FinishCheckout -> finishCheckout()
    }
}

fun navigateToCheckout() = driver.findElement(By.linkText("CHECKOUT")).click()

fun fillCheckoutInfo(firstName: String, lastName: String, zipCode: String) {
    driver.findElement(By.id("first-name")).sendKeys(firstName)
    driver.findElement(By.id("last-name")).sendKeys(lastName)
    driver.findElement(By.id("postal-code")).sendKeys(zipCode)
    driver.findElement(By.className("cart_button")).click()
}

fun finishCheckout() = driver.findElement(By.className("cart_button")).click()

sealed class Page {
    object Login : Page()
    data class Inventory(val username: String, val password: String) : Page()
    data class Item(val index: Int) : Page()
    object ShoppingCart : Page()
    object Checkout : Page()
    data class FillCheckoutInfo(val firstName: String, val lastName: String, val zipCode: String) : Page()
    object FinishCheckout : Page()
}

fun getCurrentUrl(): String = driver.currentUrl