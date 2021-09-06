package yandex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class YandexRtx {
    private final WebDriver webDriver;

    public YandexRtx(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @FindBy(how = How.XPATH, using = "//*[@class='_2AMPZ _3CFK9 _2VvV8 _3WgR5']")
    WebElement catalog;

    @FindBy(how = How.XPATH, using = "//li[@data-zone-data='{\"id\":\"97009164\"}']")
    WebElement computers;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Видеокарты')]\"")
    WebElement videocards;

    @FindBy(how = How.XPATH, using = "//*[@class='_1KpjX _2Wg9r']")
    List<WebElement> showAll;

    @FindBy(how = How.XPATH, using = "//*[@class='_1o8_r _17C4L'][contains(text(),'GTX 1060')]")
    WebElement gtx;

    @FindBy(how = How.XPATH, using = "//*[@class='_1o8_r _17C4L'][contains(text(),'GTX 1060')and not(contains(text(),'Ti'))]")
    WebElement rtx;

    @FindBy(how = How.XPATH, using = "//*[@class='_2zH77 _3tIai']")
    WebElement byPrice;

    @FindBy(how = How.XPATH, using = "//*[@class='_2zH77 _3tIai']")
    List<WebElement> gtxPrice;

    @FindBy(how = How.XPATH, using = "//*[@class='_2zH77 _3tIai']")
    List<WebElement> rtxPrice;

    public void threadSleep() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void find() {
        catalog.click();
        computers.click();
        threadSleep();
        Actions actions = new Actions(webDriver);
        actions.moveToElement(computers).build().perform();
        threadSleep();
        actions.moveToElement(videocards).click().build().perform();
        showAll.get(1).click();
    }

    public void getVideocardGTX() {
        gtx.click();
        byPrice.click();
        String getGtxPrice = gtxPrice.get(0).getText();
        System.out.println(getGtxPrice);
    }

    public void getVideocardRTX() {
        rtx.click();
        threadSleep();
        String getRtxPrice = rtxPrice.get(0).getText();
        System.out.println(getRtxPrice);
    }


}
