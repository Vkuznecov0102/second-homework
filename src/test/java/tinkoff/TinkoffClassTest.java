package tinkoff;

import base.StartFinish;
import org.junit.jupiter.api.Test;

public class TinkoffClassTest extends StartFinish {

    @Test
    public void tinkoffTest() {
        TinkoffClass tks = new TinkoffClass(webDriver);
        tks.getTinkoff();
        tks.checkSite();
        tks.getUsdAndEuroValues();
    }
}
