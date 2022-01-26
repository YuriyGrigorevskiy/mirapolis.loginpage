import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(xpath = "//input[@name='user']")
    private WebElement User;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement Password;

    @FindBy(xpath = "//*[@id='login_form_panel']/table[2]/tbody/tr/td/a")
    private WebElement ForgetPassword;

    @FindBy(xpath = "//button[@id='button_submit_login_form']")
    private WebElement LoginButton;

    public void login (String user, String password){
        User.sendKeys(user);
        Password.sendKeys(password);
        LoginButton.click();
    }
}
