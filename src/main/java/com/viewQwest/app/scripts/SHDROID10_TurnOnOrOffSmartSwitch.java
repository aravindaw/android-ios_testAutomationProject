package com.viewQwest.app.scripts;

import com.viewQwest.app.context.ClickMainPageTileContext;
import com.viewQwest.app.documents.ClickMainPageTileDocument;
import com.viewQwest.app.documents.ClickMainPageTileDocument_IOS;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.*;
import ru.yandex.qatools.allure.model.SeverityLevel;

public class SHDROID10_TurnOnOrOffSmartSwitch extends Preconditions {

    @Features("Main page activity testing")
    @Step("Click Smart Switch Icon tile ")
    @Title("Main page tile click testing")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Click a tile that can to some activity like smart switch tile. If the switch was in Off mode switch will be turned on else will be turned Off ")
    @Stories({"Smart switch turn on/off"})
    @Test
    public void clickSmartSwitchIcon() throws Exception {
        ClickMainPageTileContext context = new ClickMainPageTileContext();
        context.setTileName("Switch");

//        byte[] screenshot;
        if (device.equals(Enums.ANDROID)) {
            //turn ON
            saveScreenshot(new ClickMainPageTileDocument(context).click());
            //turn OFF
            saveScreenshot(new ClickMainPageTileDocument(context).click());
        }else {
            //turn ON
            saveScreenshot(new ClickMainPageTileDocument_IOS(context).click());
            //turn OFF
            saveScreenshot(new ClickMainPageTileDocument_IOS(context).click());
        }
    }
}
