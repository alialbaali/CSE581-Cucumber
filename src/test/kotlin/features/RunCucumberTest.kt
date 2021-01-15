package features

import io.cucumber.junit.Cucumber
import io.cucumber.junit.CucumberOptions
import org.junit.runner.RunWith

@RunWith(Cucumber::class)
@CucumberOptions(
    features = ["src/test/kotlin/features"],
    tags = "@Login and @SelectItem and @AddItemToCart and @ProceedToShoppingCart and @CheckShoppingCartItem and @ProceedToCheckout and @CompleteAndLogout",
    plugin = ["pretty", "summary"],
)
class RunCucumberTest