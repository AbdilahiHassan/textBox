import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriveCreator {
    public WebDriver createBrowse(String browser){
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "C:\\Selanium\\chromedriver.exe");
        driver = new ChromeDriver();
             return driver;

    }
}
