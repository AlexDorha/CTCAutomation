package Tests;

import Help.BaseTest;
import Help.HelpMethods;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class RegistrationTest extends BaseTest {

    //declare an object
    public HelpMethods functions=new HelpMethods(driver);

    //first automation test
    @Test
    public void register()
    {
        //Fill first name field
        WebElement firstNameWeb=driver.findElement(By.xpath("//div[@class='col-md-4 col-xs-4 col-sm-4']/input[@placeholder='First Name']"));
        String firstNameValue="Dorha";
        functions.fillWebElement(firstNameWeb,firstNameValue);

        //Click gender
        WebElement genderWeb=driver.findElement(By.xpath("//input[@value='Male']"));
        functions.clickWebElement(genderWeb);

        //language drop down special
        WebElement languageDropDown=driver.findElement(By.xpath("//div[@class='ui-autocomplete-multiselect ui-state-default ui-widget']"));
        languageDropDown.click();
        List<WebElement> languageValues=driver.findElements(By.xpath("//ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content ui-corner-all']/li/a"));
        String languageValue="Romanian";
        for(int index=0;index<languageValues.size();index++)
        {
            String currentElement=languageValues.get(index).getText();
            if(currentElement.equals(languageValue))
            {
                languageValues.get(index).click();
            }
        }


        //Select a skill
        WebElement skillDropDownWeb=driver.findElement(By.id("Skills"));
        String skillValue="Java";
        functions.selectTextWebElement(skillDropDownWeb,skillValue);

        //hover webelement
        WebElement switcchToButton=driver.findElement(By.xpath("//a[contains(.,'SwitchTo')]"));
        Actions action=new Actions(driver);
        action.moveToElement(switcchToButton).build().perform();
        WebElement windowsMenu=driver.findElement(By.xpath("//a[contains(.,'Windows')]"));
        windowsMenu.click();

        //validate windows page
        String expectedResult="Frames & windows";
        String actualResult=driver.getTitle();
        Assert.assertEquals(expectedResult,actualResult);

        //Validate windows message
        WebElement windowsMessage=driver.findElement(By.xpath("//div[@id='Tabbed']/p"));
        //Wait explicit
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(windowsMessage));

        String expectedWindowsMessage="If you set the target attribute to \"_blank\" , the link will open in a new browser window or a new tab";
        String actualWindowsMessage=windowsMessage.getText();
        Assert.assertEquals(expectedWindowsMessage,actualWindowsMessage);
    }

    //folosire @After
    @After
    public void close()
    {
        driver.quit();
    }
}
