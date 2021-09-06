package tinkoff;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TinkoffClass {
    private WebDriver webDriver;

    public TinkoffClass(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void getTinkoff() {
        webDriver.get("https://www.tinkoff.ru/about/exchange/");
    }

    public void checkSite() {
        assertEquals("Курсы валют", webDriver.getTitle());
    }

    public void getUsdAndEuroValues() {
        List<WebElement> moneyFields = webDriver.findElements(By.xpath("//*[@class='a1daNl']"));
        List<WebElement> getEuro = new ArrayList<>();
        getEuro.add(moneyFields.get(0));
        getEuro.add(moneyFields.get(1));
        System.out.println(getEuro.get(0).getText());
        System.out.println(getEuro.get(1).getText());
    }
}
