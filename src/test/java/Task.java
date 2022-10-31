import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ResultsPage;


public class Task extends BaseTest {

    @Test
    @Step("Verify pages count")
    @Description("Validate number of results on page 2 and 3 are equal or not")
    public void test() {

        ResultsPage resultsPage = homePage.search();
        Assert.assertTrue(homePage.assertSearchText());
        resultsPage.nextPage();
        Assert.assertTrue(resultsPage.assertPageNumber());
        int secondResultsPageCount = resultsPage.countResults();
        resultsPage.nextPage();
        Assert.assertTrue(resultsPage.assertPageNumber());
        int thirdResultsPageCount = resultsPage.countResults();
        Assert.assertEquals(secondResultsPageCount, thirdResultsPageCount);
    }
}
