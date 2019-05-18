package Help;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HelpMethods {

    WebDriver driver;

    //constructor
    public HelpMethods(WebDriver driver)
    {
        this.driver=driver;
    }

    //functions
    //Click WebElement
    public void clickWebElement(WebElement element)
    {
        element.click();
    }

    //fill webElement
    public void fillWebElement(WebElement element,String value)
    {
        element.sendKeys(value);
    }

    //Select by text
    public void selectTextWebElement(WebElement element,String value)
    {
        Select dropDown=new Select(element);
        dropDown.selectByVisibleText(value);
    }
}
