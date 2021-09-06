package vtb;

import base.StartFinish;
import org.junit.jupiter.api.Test;

public class VtbClassTest extends StartFinish {

    @Test
    public void tinkoffTest() {
        VtbClass vtbClass = new VtbClass(webDriver);
        vtbClass.getVtb();
        vtbClass.checkSite();
        vtbClass.getUsdValues();
    }
}
