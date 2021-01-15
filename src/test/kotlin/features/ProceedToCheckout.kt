package features

import Page
import getCurrentUrl
import io.cucumber.java8.En
import navigate
import org.junit.Assert.assertEquals

class ProceedToCheckout : En {

    init {

        Given("I am on the shopping cart page with 1 item in the cart") {
            assertEquals("https://www.saucedemo.com/cart.html", getCurrentUrl())
        }

        When("I click on the checkout button") {
            navigate(Page.FillCheckoutInfo("Ali", "Albaali", "42042"))
        }

        Then("I should be directed to the Checkout page") {
            assertEquals("https://www.saucedemo.com/checkout-step-one.html", getCurrentUrl())
        }

    }

}