import net.bytebuddy.implementation.bind.annotation.FieldProxy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends BasePage {

    @FindBy(xpath = "//div[@data-dmid = 'search-result-header']")
    WebElement searchResultsTabLocator;

    @FindBy(xpath = "//h3[@data-dmid = 'dm-heading']")
    WebElement searchErrorMessage;

    public SearchResultPage(ChromeDriver driver) {
        super(driver);
    }

    public boolean isSearchResultsPresent() {
        print("isSearchResultsPresent");
        return isElementPresent(searchResultsTabLocator);
    }

    public String getSearchErrorMessage() {
        print("getSearchErrorMessage");
        return searchErrorMessage.getText();
    }


}
