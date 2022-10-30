import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ResultsPage;
import utils.Utilities;


public class Task extends BaseTest {

    @Test
    public void test(){
        ResultsPage resultsPage = homePage.search();

        Assert.assertTrue(resultsPage.assertPageNumber());

        resultsPage.nextPage();
        Assert.assertTrue(resultsPage.assertPageNumber());
        int x = resultsPage.countResults();
        resultsPage.nextPage();
        Assert.assertTrue(resultsPage.assertPageNumber());
        int y = resultsPage.countResults();
        Assert.assertEquals(x,y);
    }
}
