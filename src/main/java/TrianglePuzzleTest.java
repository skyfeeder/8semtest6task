import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TrianglePuzzleTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://playground.learnqa.ru/puzzle/triangle");

        WebElement giveUpButton = driver.findElement(By.xpath("//button[contains(text(),'Я сдаюсь')]"));

        if (giveUpButton.isDisplayed()) {
            giveUpButton.click();

            WebElement answersLink = driver.findElement(By.linkText("Ссылка на ответы"));

            if (answersLink.isDisplayed()) {
                System.out.println("Ссылка на ответы найдена");

                WebElement hideAnswersButton = driver.findElement(By.xpath("//button[contains(text(),'Спрятать ответы')]"));

                if (hideAnswersButton.isDisplayed()) {
                    System.out.println("Кнопка 'Спрятать ответы' найдена");
                } else {
                    System.out.println("Кнопка 'Спрятать ответы' не найдена");
                }
            } else {
                System.out.println("Ссылка на ответы не найдена");
            }
        } else {
            System.out.println("Кнопка 'Я сдаюсь' не найдена");
        }

        driver.quit();
    }
}