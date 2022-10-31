package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class ResultsPage {
    public ResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver driver;
    private By nextButton = By.id("pnnext");
    private By searchResults = By.cssSelector("h3[class='LC20lb MBeuO DKV0Md']");
    private By pageStatus = By.id("result-stats");
    public static Integer counter = 1;


    public void scrollPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void nextPage() {
        counter++;
        scrollPage();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(nextButton));
        driver.findElement(nextButton).click();
    }

    public int countResults() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchResults));
        return driver.findElements(searchResults).size();
    }

    public String getPageStatus() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageStatus));
        return driver.findElement(pageStatus).getText();
    }

    public Boolean assertPageNumber() {
        String pageNumber = Integer.toString(counter);
        return getPageStatus().contains(pageNumber);
    }


}
