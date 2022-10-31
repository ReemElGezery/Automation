import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.Utilities;

import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    private WebDriver driver;
    protected HomePage homePage;

    private Utilities util = new Utilities();
    private String URL = util.readTestData(1, 0);

    @BeforeClass
    public void setUp() throws IOException {
        Properties prop = util.setupProp();
        String browser = prop.getProperty("browser");
        switch (browser) {

            case "CH":

                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case "FF":

                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            case "Edge":

                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;

            default:
                driver = null;
                break;

        }


    }

    @BeforeMethod
    public void goHome() {
        driver.manage().window().maximize();
        driver.get(URL);
        homePage = new HomePage(driver);

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }


}
