package pages;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import utils.Utilities;


public class HomePage {

   public HomePage (WebDriver driver){this.driver = driver;}

    Utilities util = new Utilities();
   private String searchText= util.readTestData(1,1);


   private By searchInput = By.name("q");
   private WebDriver driver ;



   public ResultsPage search()
   {
       driver.findElement(searchInput).sendKeys(searchText + Keys.ENTER);
       return new ResultsPage(driver);
   }
}
