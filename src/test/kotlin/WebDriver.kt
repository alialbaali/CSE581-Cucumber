import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver
import java.util.concurrent.TimeUnit

fun setupWebDriver(): WebDriver {
    System.setProperty(
        "webdriver.gecko.driver",
        "C:\\Users\\ali\\Downloads\\geckodriver\\geckodriver.exe"
    )
    return FirefoxDriver().apply {
        manage()
            .window()
            .maximize()

        manage()
            .timeouts()
            .implicitlyWait(10, TimeUnit.SECONDS)
    }
}