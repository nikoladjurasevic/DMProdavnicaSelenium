import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    /**
     * Search for valid brand
     * steps:
     * 1. Navigate to home page
     * 2. enter valid brand name into search field
     * 3. click search and submit button
     *
     * Expected result:
     * 3. Verify that the search results have been shown
     */
    @Test
    public void searchBrandTest() {
        ChromeDriver driver = openChromeDriver();
        try {
            HomePage homePage = new HomePage(driver);
            homePage.searchAndSubmit("Nivea");
            SearchResultPage searchResultPage = new SearchResultPage(driver);
            assert searchResultPage.isSearchResultsPresent() : "There are NO search results";

        }finally {
            driver.quit();
        }
    }

    /**
     * Search for invalid brand
     * steps:
     * 1. Navigate to home page
     * 2. enter invalid brand name into search field
     * 3. click search and submit button
     *
     * Expected result:
     * 3. Verify that the there are NOT search results
     */
    @Test
    public void searchInvalidBrandTest() {
        ChromeDriver driver = openChromeDriver();
        String invalidBrand = "trtmrt";
        String expectedSearchErrorMSG = Strings.SEARCH_ERROR_MSG.replace("„%TEXT%”",invalidBrand);
        try {
            HomePage homePage = new HomePage(driver);
            sleep();
            homePage.searchAndSubmit("blablatruc");
            SearchResultPage searchResultPage = new SearchResultPage(driver);
            sleep();
            assert !searchResultPage.isSearchResultsPresent() : "There should be no results, but there ARE";
            String actualErrorMessage = searchResultPage.getSearchErrorMessage();
            assert actualErrorMessage.equals(expectedSearchErrorMSG) : "Error. Wrong message" +
                    "Expected: " + expectedSearchErrorMSG + " .Actual " + actualErrorMessage;

        }finally {
            driver.quit();
        }
    }

}
