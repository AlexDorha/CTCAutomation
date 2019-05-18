package Help;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {

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
}
