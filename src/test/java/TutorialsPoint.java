import com.github.javafaker.Faker;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TutorialsPoint {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeAll
    public  void setUp() throws IOException, ParseException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));

    }

    @Order(2)
    @Test
    public void tutorialsPointAutomation() throws InterruptedException {
        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        Utils.scrollDown(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //List<WebElement> userFormElement =  driver.findElements(By.className("form-control"));
        Faker faker = new Faker();
        //FirstName
        String firstName = faker.name().firstName();
        driver.findElement(By.id("name")).sendKeys(firstName);
        //Email
        driver.findElement(By.id("email")).sendKeys(faker.name().firstName().toLowerCase()+"@test.com");
        //Gender
        WebElement maleRadio = driver.findElement(By.id("gender"));
        js.executeScript("arguments[0].scrollIntoView(true);", maleRadio);
        Thread.sleep(300);
        maleRadio.click();

        //Mobile No
        String phoneNo = "0130"+Utils.generateRandomMobileNo(100000,999999);
        driver.findElement(By.id("mobile")).sendKeys(phoneNo);
        //DOB
        WebElement dob = driver.findElement(By.id("dob"));
        dob.click();
        dob.sendKeys(Keys.CONTROL + "a");
        dob.sendKeys(Keys.DELETE);
        dob.sendKeys("01/02/1998");

        //subjects
        driver.findElement(By.id("subjects")).sendKeys("Testing");

        //type
        driver.findElement(By.xpath("//label[text()='Reading']/preceding-sibling::input")).click();

        //image
        driver.findElement(By.id("picture")).sendKeys(System.getProperty("user.dir")+"/src/test/resources/image.png"); // photo upload

        //address
        driver.findElement(By.cssSelector("textarea.form-control")).sendKeys("123 Dhaka, Bangladesh");

        // State select
        WebElement stateElement = driver.findElement(By.id("state"));
        js.executeScript(
                "arguments[0].value = 'Uttar Pradesh';" +
                        "arguments[0].dispatchEvent(new Event('change', {bubbles:true}));",
                stateElement
        );
        Thread.sleep(1000);

        // City select
        WebElement cityElement = driver.findElement(By.id("city"));
        js.executeScript(
                "arguments[0].value = 'Lucknow';" +
                        "arguments[0].dispatchEvent(new Event('change', {bubbles:true}));",
                cityElement
        );
        Thread.sleep(500);

        // Submit
        //driver.findElement(By.cssSelector("[type=submit]")).click();
        WebElement submitBtn = driver.findElement(By.cssSelector("[type=submit]"));
        js.executeScript("arguments[0].scrollIntoView(true);", submitBtn);
        Thread.sleep(500);
        js.executeScript("arguments[0].click();", submitBtn);

        // Assert
        Assertions.assertNotEquals("true",
                driver.findElement(By.id("state")).getAttribute("aria-invalid"),
                "State validation failed!");

        Assertions.assertNotEquals("true",
                driver.findElement(By.id("city")).getAttribute("aria-invalid"),
                "City validation failed!");

        System.out.println("Registration Successful! Name: " + firstName);


    }

    @AfterAll
    public void closeDriver() {
        driver.quit();
    }
}
