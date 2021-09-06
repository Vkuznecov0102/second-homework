package vtb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VtbClass {
    private WebDriver webDriver;

    public VtbClass(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void getVtb() {
        webDriver.get("https://www.vtb.ru/personal/platezhi-i-perevody/obmen-valjuty/");
    }

    public void checkSite() {
        assertEquals("Обмен валюты: продажа и покупка валюты, курсы валют в Банке ВТБ", webDriver.getTitle());
    }

    public void getUsdValues() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> moneyFields = webDriver.findElements(By.xpath("//*[@class='exchange-rate-table__index ng-binding ng-scope exchange-rate-table__index_up']"));
        System.out.println(moneyFields.get(0).getText());
        System.out.println(moneyFields.get(1).getText());
    }
}
