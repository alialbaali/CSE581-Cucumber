import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

private val driver: WebDriver = setupWebDriver()

const val DefaultUrl = "https://www.saucedemo.com/"
const val InventoryPageUrl = "https://www.saucedemo.com/inventory.html"

const val DefaultUsername = "standard_user"
const val DefaultPassword = "secret_sauce"

private val userNameInput by lazy { driver.findElement(By.id("user-name")) }
private val passwordInput by lazy { driver.findElement(By.id("password")) }
private val loginButton by lazy { driver.findElement(By.id("login-button")) }

fun login(username: String, password: String): String {
    userNameInput.sendKeys(username)
    passwordInput.sendKeys(password)
    loginButton.click()
    return if (username.equals(DefaultUsername, true)) "success" else "failure"
}

fun navigateToItem(index: Int) {
    getInventoryItems()[index]
        .findElement(By.className("inventory_item_img"))
        .click()
}

fun getInventoryItems(): List<WebElement> {
    return driver.findElements(By.className("inventory_item"))
}

fun navigate(page: Page) {
    when (page) {
        is Page.Login -> driver.get(DefaultUrl)
        is Page.Inventory -> login(page.username, page.password)
        is Page.Item -> navigateToItem(page.index)
    }
}

sealed class Page {
    object Login : Page()
    data class Inventory(val username: String, val password: String) : Page()
    data class Item(val index: Int) : Page()
}

fun getCurrentUrl() = driver.currentUrl