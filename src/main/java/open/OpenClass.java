package open;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OpenClass {

    private final WebDriver webDriver;

    public OpenClass(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void getOpen() {
        webDriver.get("https://www.open.ru/");
    }

    public void checkSite() {
        assertEquals("Частным клиентам | Банк Открытие", webDriver.getTitle());
    }

    public String getUsdAndEuroValues() {
        List<WebElement> moneyFields = webDriver.findElements(By.xpath("//*[@class='main-page-exchange__table main-page-exchange__table--online']" +
                "//*/tr[@class='main-page-exchange__row main-page-exchange__row--with-border']"));
        final WebElement[] usdField = new WebElement[1];
        final WebElement[] eurField = new WebElement[1];

        moneyFields.forEach(x -> {
            if (x.getText().contains("USD")) {
                usdField[0] = webDriver.findElement(By.xpath("//*/tr[@class='main-page-exchange__row main-page-exchange__row--with-border']//*[contains(text(),'USD')]"));
            } else if (x.getText().contains("EUR")) {
                eurField[0] = webDriver.findElement(By.xpath("//*/tr[@class='main-page-exchange__row main-page-exchange__row--with-border']//*[contains(text(),'EUR')]"));
            }
        });

        List<WebElement> usd = usdField[0].findElements(By.xpath("//*/span[@class='main-page-exchange__rate']"));
        double bankBuyUSD = Double.parseDouble(usd.get(0).getText().replace(",", "."));
        double bankSellUSD = Double.parseDouble(usd.get(1).getText().replace(",", "."));

        double bankBuyEUR = Double.parseDouble(usd.get(2).getText().replace(",", "."));
        double bankSellEUR = Double.parseDouble(usd.get(3).getText().replace(",", "."));

        List<Double> result = new ArrayList<>(List.of(bankBuyUSD, bankSellUSD, bankBuyEUR, bankSellEUR));
        return result.toString();
    }

}
