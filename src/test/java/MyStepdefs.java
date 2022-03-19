import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyStepdefs {
    private String myName, myEmail, myCurrent, myPermenent;
    private WebDriver driver;

    @Given("I have written my name {string}")
    public void iHaveWrittenMyName(String name) {
        myName = name;
        // System.out.println(name);
     // System.setProperty("webdriver.chrome.driver", "C:\\Selanium\\chromedriver.exe");
       // driver = new ChromeDriver();
        DriveCreator creator = new DriveCreator();
        driver= creator.createBrowse("chrome");
        driver.get("https://demoqa.com/text-box");

        //System.setProperty("webdriver.edge.driver", "C:\\Selanium\\msedgedriver.exe");
       //  driver = new EdgeDriver();
         // driver.get("https://demoqa.com/text-box");

//C:\Selanium
        sendKeys(driver, By.id("userName"), name);

    }

    @Given("I have written my email {string}")
    public void iHaveWrittenMyEmail(String email) {
        myEmail = email;
        //System.out.println(email);
        sendKeys(driver, By.id("userEmail"), email);

    }

    @Given("I have written my current address {string}")
    public void iHaveWrittenMyCurrentAddress(String current) {
        myCurrent = current;
        // System.out.println(current);
        sendKeys(driver, By.id("currentAddress"), current);

    }

    @Given("I have written my perment addrrss {string}")
    public void iHaveWrittenMyPermentAddrrss(String perment) {
        myPermenent = perment;
        //System.out.println(perment);
        sendKeys(driver, By.id("permanentAddress"), perment);

    }

    @When("I click the Submit button")
    public void iClickTheSubmitButton() {
        scroll(driver);
        click(driver, By.id("submit"));
    }

    @Then("my contact information is displayed")
    public void myContactInformationIsDisplayed() {

        String expected = "name:" + myName + "\n" +
                "email:" + myEmail + "\n" +
                "current Address :" + myCurrent + "\n" +
                "perment Address:" + myPermenent;

        String actual = getText(driver, By.cssSelector("div[class='border col-md-12 col-sm-12']"));
        //System.out.println(actual);
        assertEquals(expected, actual);
        driver.quit();
    }

    private void assertEquals(String expect, String actual) {

    }


    private String getText(WebDriver driver, By by) {
        WebDriverWait footbarr = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = footbarr.until(ExpectedConditions.presenceOfElementLocated(by));
        String text = element.getText();
        return text;
    }


    private static void scroll(WebDriver driver) {

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,200)");
    }

    private static void sendKeys(WebDriver driver, By by, String text) {
        WebDriverWait footbarr = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = footbarr.until(ExpectedConditions.presenceOfElementLocated(by));
        element.sendKeys(text);

    }

    private static void click(WebDriver driver, By by) {
        WebDriverWait footbar = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = footbar.until(ExpectedConditions.elementToBeClickable(by));
        element.click();


    }


    /*

    @Then("Hassan's contact information is displayed")
    public void hassanSContactInformationIsDisplayed() {
        String actual = getText(driver,By.cssSelector("div[class='border col-md-12 col-sm-12']"));
        String expect ="Name:Hassan\n" +
                "partille\n" +
                "stockholm\n" +
                "Email:hassan@gmail.com\n" +
                "Current Address :partille\n" +
                "Permananet Address :stockholm";
        //System.out.println(actual);
        assertEquals(expect, actual);
        driver.quit();

    }


    @Then("Amina's contact information is displayed")
    public void aminaSContactInformationIsDisplayed() {
        String actual = getText(driver,By.cssSelector("div[class='border col-md-12 col-sm-12']"));
        String expect ="Name:Amina\n" +
                "Email:Amina@gmail.com\n" +
                "Current Address :vaxjo\n" +
                "Permananet Address :host";
        //System.out.println(actual);
        assertEquals(expect, actual);
        driver.quit();
    }

     */

}
