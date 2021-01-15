package features

import Page
import getCurrentUrl
import getShoppingCartItems
import io.cucumber.java8.En
import navigate
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue

class ProceedToShoppingCart : En {

    init {

        Given("I am on the inventory item page") {
            assertTrue(getCurrentUrl().contains("id=4"))
        }

        When("I click on the shopping cart icon in the navbar") {
            navigate(Page.ShoppingCart)
        }

        Then("I should be directed to the shopping cart page") {
            assertEquals("https://www.saucedemo.com/cart.html", getCurrentUrl())
        }

    }

}