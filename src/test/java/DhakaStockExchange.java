import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DhakaStockExchange {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeAll
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    }

    @Test
    public void printAndStoreCellValues() throws IOException {
        driver.get("https://dsebd.org/latest_share_price_scroll_by_value.php");
        int previousRowCount = 0;
        while (true) {
            List<WebElement> currentRows = driver.findElements(By.cssSelector("table.table-bordered tr"));
            int currentRowCount = currentRows.size();
            if (currentRowCount == previousRowCount) break;
            previousRowCount = currentRowCount;
            Utils.scrollDown(driver);

            int finalPreviousRowCount = previousRowCount;
            try {
                wait.until(driver ->
                        driver.findElements(By.cssSelector("table.table-bordered tr")).size() > finalPreviousRowCount
                );
            } catch (TimeoutException e) {
                break;
            }
        }

        List<WebElement> rows = driver.findElements(By.cssSelector("table.table-bordered tr"));
        StringBuilder sb = new StringBuilder();

        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.xpath(".//th | .//td"));

            if (cells.isEmpty()) continue;
            String firstCell = cells.get(0).getText().trim();
            if (!firstCell.matches("\\d+")) continue;

            StringBuilder rowLine = new StringBuilder();
            for (int i = 0; i < cells.size(); i++) {
                String cellText = cells.get(i).getText().trim();
                rowLine.append(cellText);
                if (i < cells.size() - 1) {
                    rowLine.append(" | ");
                }
            }
            String line = rowLine.toString();
            System.out.println(line);
            sb.append(line).append("\n");

            //Utils.scrollDown(driver);
            //wait.until(ExpectedConditions.visibilityOf(table));
        }

        System.out.println("Total Rows Captured: " + (rows.size() - 2));
        Utils.writeToFile(sb.toString());
    }

    @AfterAll
    public void closeDriver() {
        driver.quit();
    }
}