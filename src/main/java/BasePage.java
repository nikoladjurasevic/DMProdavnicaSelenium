import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    //web elementi
    @FindBy(xpath = "//a[@data-dmid = 'logo-link']")
    WebElement logoLocator;

    @FindBy(xpath = "//input[@id = 'input-search-composing-search-input-field']")
    WebElement searchInputLocator;

    @FindBy(xpath = "//button[@data-dmid = 'search-submit']")
    WebElement searchSubmitButtonLocator;

    ChromeDriver driver = null;

    //consturctor
    public BasePage(ChromeDriver driver) {
        print("BasePage");
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public static void print(String s) {
        System.out.println(s);
    }

    //methods on page
    public void enterTextIntoSearchField(String text) {
        print("enterTextIntoSearchField");
        waitForElement(searchInputLocator,1);
        searchInputLocator.click();
        waitForElement(searchInputLocator,1);
        searchInputLocator.sendKeys(text);
    }

    public void clickSearchAndSubmitButton() {
        print("clickSearchAndSubmitButton");
//        WebDriverWait wait = new WebDriverWait(driver, 5);
//        wait.until(ExpectedConditions.visibilityOf(searchSubmitButtonLocator));
        waitForElement(searchInputLocator, 2);
        searchSubmitButtonLocator.click();
    }

    public void searchAndSubmit(String text) {
        print("searchAndSubmit");
        enterTextIntoSearchField(text);
        clickSearchAndSubmitButton();
    }

    //da li je neki web element prisutan nas stranici
    public boolean isElementPresent(WebElement element) {
        try {
            boolean isPresent = element.isDisplayed();
            return true;
        } catch (Exception e) {
            print(e.getMessage());
            print("Element is not present on page");
            return  false;
        }
    }

    public void waitForElement(WebElement element, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

}
