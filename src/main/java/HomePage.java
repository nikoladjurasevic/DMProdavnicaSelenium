import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {


    //webelements
    @FindBy(xpath = "//ul[@data-dmid = 'desktop-navigation-items']")
    WebElement mainMenuItemsLocator;

    @FindBy(xpath = "//button[@data-testid = 'uc-accept-all-button']")
    WebElement consentOnCookiesButtonLocator;

    @FindBy(xpath = "//div[@id = 'usercentrics-root']")
    WebElement shadowRootLocator;


    //constructor
    public HomePage(ChromeDriver driver) {
        super(driver);
        print("HomePage");
        clickConsentOnCookies();
    }

    public void clickConsentOnCookies() {
        print("clickConsentOnCookies()");
        //TODO dodaj deo za shadow root
    }

    public void clickOnMainMenuLink(String linkText) {
        print("clickOnMainMenuLink ( " + linkText + " )");
        List<WebElement> list = mainMenuItemsLocator.findElements(By.xpath(".//a[@data-dmid = 'dm-link']"));
        for (WebElement item : list) {
            String itemText = item.getText();
            if(itemText.equals(linkText)) {
                print("Clicking on " + linkText);
                item.click();
                break;
            }
        }
    }
}
