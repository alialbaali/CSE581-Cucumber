package features

import Page
import io.cucumber.java8.En
import login
import navigate
import org.junit.Assert.assertEquals
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.WebDriverWait

class Login : En {

    private var status = "failure"

    init {

        Given("I am on the Login Page of Saucedemo") {
            navigate(Page.Login)
        }

        When("I enter a {string} and {string}") { username: String, password: String ->
            status = login(username, password)
        }

        Then("the login status should be {string}") { status: String ->
            assertEquals(this.status, status)
        }
    }

}

fun <V> WebDriver.waitUntil(timeOutInSeconds: Long = 10, block: WebDriver.() -> V) = try {
    WebDriverWait(this, timeOutInSeconds).until(block)
    block()
} catch (exception: Throwable) {
    null
}