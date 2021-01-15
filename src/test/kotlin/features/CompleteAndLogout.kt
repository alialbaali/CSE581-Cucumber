package features

import Page
import getCurrentUrl
import io.cucumber.java8.En
import logout
import navigate
import org.junit.Assert.assertEquals

class CompleteAndLogout : En {

    init {
        Given("I am on the checkout page") {
            navigate(Page.Checkout)
        }
        And("I fill my checkout info") {
            navigate(Page.FillCheckoutInfo("Ali", "Albaali", "42042"))
        }
        When("I click the finish button") {
            navigate(Page.FinishCheckout)
        }
        Then("I should have my order complete") {
            assertEquals("https://www.saucedemo.com/checkout-complete.html", getCurrentUrl())
        }
        And("I logout") {
            logout()
        }
    }

}