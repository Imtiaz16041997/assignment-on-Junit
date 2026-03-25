import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.io.FileWriter;
import java.io.IOException;

public class Utils {
    public static void scrollDown(WebDriver driver){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public static int generateRandomMobileNo(int min , int max){
        double randomNumber  = Math.random() *  (max - min) + min;
        return (int) randomNumber;
    }

    public static void writeToFile(String content) throws IOException {
        String filePath = "./src/test/resources/dse_share_prices.txt";

        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(content);
            System.out.println("\n Data successfully written to: " + filePath);
        } catch (IOException e) {
            System.err.println("Failed to write file: " + e.getMessage());
            throw e;
        }
    }


}
