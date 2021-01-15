package features

import addCurrentItemToCart
import getCurrentUrl
import io.cucumber.java8.En
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import shoppingCartIconBadgeCount

class AddItemToCart : En {

    init {

        Given("I am on the item page") {
            assertTrue(getCurrentUrl().contains("id=4"))
        }

        When("I click on the add to cart button") {
            addCurrentItemToCart()
        }

        Then("the item should be added to the cart") {
            assertEquals(1, shoppingCartIconBadgeCount())
        }

    }

}