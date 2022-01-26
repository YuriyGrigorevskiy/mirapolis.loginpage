import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class LoginPageTestNegative {
    private WebDriver driver;

    @BeforeClass
    public void setup () throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("config.properties"));
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("user.properties"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void loginPageNegative(){
        LoginPage a = PageFactory.initElements(driver,LoginPage.class);
        driver.get("https://lmslite47vr.demo.mirapolis.ru/mira");
        a.login(System.getProperty("user"),"00012300213A");
        Assert.assertEquals("Неверные данные для авторизации",driver.switchTo().alert().getText());
    }

    @AfterTest
    public void after (){
        driver.quit();
    }
}
