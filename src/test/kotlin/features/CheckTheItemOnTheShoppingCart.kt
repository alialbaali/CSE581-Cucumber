package features

import getCurrentUrl
import getShoppingCartItems
import io.cucumber.java8.En
import org.junit.Assert.assertEquals

class CheckTheItemOnTheShoppingCart : En {
    var shoppingCartItemsCount = 0

    init {
        Given("I am on the shopping cart page") {
            assertEquals("https://www.saucedemo.com/cart.html", getCurrentUrl())
        }

        When("I count the items on the shopping cart page") {
            shoppingCartItemsCount = getShoppingCartItems().count()
        }

        Then("the sum should be exactly 1") {
            assertEquals(1, shoppingCartItemsCount)
        }
    }

}