package ru.gb.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.Thread.sleep;
import static org.openqa.selenium.WebDriver.*;

public class SeleniumLevelOne {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.edgedriver().setup();
        WebDriver edgeDriver = new EdgeDriver();
        edgeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        edgeDriver.get("https://accuweather.com");

        WebElement inputSearch = edgeDriver.findElement(By.xpath("//input[@placeholder='Поиск']"));
        inputSearch.sendKeys("Анталья");
        WebDriverWait edgeDriverWait = new WebDriverWait(edgeDriver, Duration.ofSeconds(5));

        edgeDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[.= 'Анталья, Анталья, TR']")));
        edgeDriver.findElement(By.xpath("//div[.= 'Анталья, Анталья, TR']")).click();

        sleep(8000);

        //edgeDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Почасовой')]")));
        //edgeDriver.findElement(By.xpath("//a[contains(text(),'Почасовой')]")).click();
        //sleep(20000);
// С почасовым прогнозом что-то не получилось

        edgeDriver.quit();
    }
}
