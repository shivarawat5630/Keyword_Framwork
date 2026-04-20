package keywords;

 
import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Keywords extends BaseTest {

    public void click(String locatorType, String locatorValue) {
        WebElement element = getElement(locatorType, locatorValue);
        element.click();
    }

    public void type(String locatorType, String locatorValue, String value) {
        WebElement element = getElement(locatorType, locatorValue);
        element.sendKeys(value);
    }

    public String getText(String locatorType, String locatorValue) {
        return getElement(locatorType, locatorValue).getText();
    }

    public WebElement getElement(String locatorType, String locatorValue) {
        switch (locatorType.toLowerCase()) {
            case "id":
                return driver.findElement(By.id(locatorValue));
            case "name":
                return driver.findElement(By.name(locatorValue));
            case "xpath":
                return driver.findElement(By.xpath(locatorValue));
            case "css":
                return driver.findElement(By.cssSelector(locatorValue));
            default:
                throw new RuntimeException("Invalid locator type");
        }
    }
}