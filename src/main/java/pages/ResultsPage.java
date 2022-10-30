package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;




public class ResultsPage {
    public ResultsPage(WebDriver driver){this.driver = driver;}

    private WebDriver driver ;
    private By nextButton = By.id("pnnext");
    private By searchResults = By.cssSelector("h3[class='LC20lb MBeuO DKV0Md']");
    private By pageStatus = By.id("result-stats");
    public static Integer counter=1;

    public void scrollPage(){
        //Scroll down till the bottom of the page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void nextPage(){
        counter++;
        scrollPage();
        driver.findElement(nextButton).click();
    }

    public int countResults(){
       return driver.findElements(searchResults).size();

    }
    public String getPageStatus() {
        return driver.findElement(pageStatus).getText();
    }

    public Boolean assertPageNumber(){
        String pageNumber = Integer.toString(counter);
        return getPageStatus().contains(pageNumber);


    }


}
