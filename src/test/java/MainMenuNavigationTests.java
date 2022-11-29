import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MainMenuNavigationTests extends BaseTest{

    @Test
    public void mainMenuNavigationTest() {
        ChromeDriver driver = openChromeDriver();
        try {
            HomePage homePage = new HomePage(driver);
            homePage.clickOnMainMenuLink(Strings.NEGA_I_PARFEMI);
            assert isCurrentURLEqualTo(driver, Strings.NEGA_I_PARFEMI_URL) : "User is NOT on expected page. " +
                    "Expected: " + Strings.NEGA_I_PARFEMI_URL + " . Actual: " + driver.getCurrentUrl();

        }finally {
//            driver.quit();
        }
    }



}
