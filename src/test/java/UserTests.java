import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

public class UserTests {


    WebDriver driver;
    WebDriverWait webDriverWait;
    String email = "Auto@test12.com";
    String passwrod = "9AWtqC3je!fQ@6R";
    String url = "http://automationpractice.com/index.php";
    By signInLinkLocator = By.partialLinkText("Sign in");
    By emailFIeldLocator = By.id("email");
    By passwordFieldLocator = By.id("passwd");
    By signInBtnLocator =By.id("SubmitLogin");
    By loginPageHeaderLocator =By.xpath("//*[@id=\"center_column\"]/h1");
    SoftAssert softAssert;

    @BeforeClass
    public void beforeClass(){

        WebDriverManager.chromedriver().clearPreferences();
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver,10);
        driver.navigate().to(url);
    }



    @Test()
    public void LoginTest(){

        softAssert= new SoftAssert();
        WebElement signIn =driver.findElement(signInLinkLocator);
        signIn.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(emailFIeldLocator));
        WebElement loginPageHeader =driver.findElement(loginPageHeaderLocator);
        softAssert.assertEquals(loginPageHeader.getText(),"Authentication");
        softAssert.assertTrue(loginPageHeader.getText().equalsIgnoreCase("Authentication"),"Login page header should be authentication");
        softAssert.assertAll();


        WebElement emailField = driver.findElement(emailFIeldLocator);
        emailField.sendKeys(email);

        webDriverWait.until(ExpectedConditions.elementToBeClickable(passwordFieldLocator));
        WebElement passwordField = driver.findElement(passwordFieldLocator);
        passwordField.sendKeys(passwrod);

        webDriverWait.until(ExpectedConditions.elementToBeClickable(signInBtnLocator));
        WebElement signinBtn =driver.findElement(signInBtnLocator);
        signinBtn.click();




    }

}
