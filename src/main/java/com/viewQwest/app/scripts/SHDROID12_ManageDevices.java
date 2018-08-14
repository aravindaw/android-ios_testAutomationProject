package com.viewQwest.app.scripts;

import com.viewQwest.app.context.ManageDevicesContext;
import com.viewQwest.app.context.SettingsMenuContext;
import com.viewQwest.app.documents.ClickSettingsButtonDocument;
import com.viewQwest.app.documents.ManageDevicesDocument;
import com.viewQwest.app.documents.SettingsMenuDocument;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.*;
import ru.yandex.qatools.allure.model.SeverityLevel;

public class SHDROID12_ManageDevices extends Preconditions {

    @Features("Manage Devices page testing")
    @Step("Go to device manage page ")
    @Title("Go to device manage page")
    @Severity(SeverityLevel.CRITICAL)
    @Description("User should be able to access device manage page without any errors..")
    @Stories({"Access device manager page"})
    @Test
    public void deviceManage() throws Exception {
        new ClickSettingsButtonDocument().click();
        new SettingsMenuDocument(new SettingsMenuContext("Manage Devices")).click();
        byte[] screenshot = new ManageDevicesDocument(new ManageDevicesContext("Smart Switch")).click();
        saveScreenshot(screenshot);
    }

}
