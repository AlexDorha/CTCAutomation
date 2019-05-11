package Tests;

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
import java.util.concurrent.TimeUnit;

public class RegistrationTest {

    public WebDriver driver;

    //folosire @Before
    @Before
    public void setup()
    {
        System.setProperty("webdriver.chrome.driver","C:\\Automation\\ChromeDriver\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("http://demo.automationtesting.in/Register.html");
        driver.manage().window().maximize();
        //wait implicit
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    //first automation test
    @Test
    public void register()
    {
        //Fill first name field
        WebElement firstNameWeb=driver.findElement(By.xpath("//div[@class='col-md-4 col-xs-4 col-sm-4']/input[@placeholder='First Name']"));
        String firstNameValue="Dorha";
        firstNameWeb.sendKeys(firstNameValue);

        //Click gender
        WebElement genderWeb=driver.findElement(By.xpath("//input[@value='Male']"));
        genderWeb.click();

        //Select a skill
        WebElement skillDropDownWeb=driver.findElement(By.id("Skills"));
        Select skillDropDown=new Select(skillDropDownWeb);
        String skillValue="Java";
        skillDropDown.selectByIndex(1);

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
