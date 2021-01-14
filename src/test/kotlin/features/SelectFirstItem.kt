package features

import DefaultPassword
import DefaultUsername
import InventoryPageUrl
import Page
import getCurrentUrl
import getInventoryItems
import io.cucumber.java8.En
import navigate
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue

class SelectFirstItem : En {

    init {

        Given("I'm on the login page") {
            navigate(Page.Login)
        }

        When("I enter a valid username and password") {
            navigate(Page.Inventory(DefaultUsername, DefaultPassword))
        }

        Then("I should be directed to the inventory page") {
            assertEquals(InventoryPageUrl, getCurrentUrl())
        }

        Given("I'm on the inventory page") {
            assertTrue(getInventoryItems().count() == 6)
        }

        When("I click on the first item") {
            navigate(Page.Item(0))
        }

        Then("it should navigate to the item page") {
            assertTrue(getCurrentUrl().contains("id=4"))
        }

    }

}