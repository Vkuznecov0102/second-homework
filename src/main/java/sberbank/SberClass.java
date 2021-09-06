package sberbank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SberClass {
    private final WebDriver webDriver;

    public SberClass(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void getSberSite() {
        webDriver.get("https://www.sberbank.ru/ru/person");
    }

    public void checkSite() {
        assertEquals("Частным клиентам — СберБанк", webDriver.getTitle());
    }

    public void getUsdAndEurValues() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> currencies = webDriver.findElements(By.xpath("//*//*[@class='currency-table__iso-number currency-table__iso-number_increase']"));
        System.out.println(currencies.size());

//        List<WebElement> moneyFields = webDriver.findElements(By.xpath("//*[@class='kitt-grid']" +
//                "//*/*[@class='kitt-row currency-table__iso']"));
//        final WebElement[] usdField = new WebElement[1];
//        final WebElement[] eurField = new WebElement[1];
//
//        moneyFields.forEach(x->{
//
//                usdField[0] = webDriver.findElement(By.xpath("//*//*[@class='kitt-row currency-table__iso']//*[contains(text(),'USD')]"));
//
//
//                eurField[0] = webDriver.findElement(By.xpath("//*/*/*[@class='kitt-row currency-table__iso']//*[contains(text(),'EUR')]"));
//
//        });
//
//        System.out.println(usdField[0]);
//
//
//        List<WebElement> usd = usdField[0].findElements(By.xpath("//*/*[@class='currency-table__iso-number currency-table__iso-number_decrease']"));
//        double bankBuyUSD = Double.parseDouble(usd.get(0).getText().replace(",","."));
//        double bankSellUSD = Double.parseDouble(usd.get(1).getText().replace(",","."));
//
//        double bankBuyEUR = Double.parseDouble(usd.get(2).getText().replace(",","."));
//        double bankSellEUR = Double.parseDouble(usd.get(3).getText().replace(",","."));
//
//        List<Double> result=new ArrayList<>(List.of(bankBuyUSD, bankSellUSD, bankBuyEUR, bankSellEUR));
//        return result.toString();
    }
}
