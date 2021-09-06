package yandex;

import base.StartFinish;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

public class YandexRtxTest extends StartFinish {

    @Test
    public void mainTest() {
        webDriver.get("https://market.yandex.ru/");
        yandex.YandexRtx yandexRtxTest = PageFactory.initElements(webDriver, yandex.YandexRtx.class);
        yandexRtxTest.find();
        yandexRtxTest.getVideocardGTX();
        yandexRtxTest.getVideocardRTX();
    }
}
