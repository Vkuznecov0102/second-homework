package sberbank;

import base.StartFinish;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

public class SberClassTest extends StartFinish {

    @Test
    public void mainTest() {
        SberClass sberClass = new SberClass(webDriver);
        sberClass.getSberSite();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        sberClass.checkSite();
        sberClass.getUsdAndEurValues();
    }
}
