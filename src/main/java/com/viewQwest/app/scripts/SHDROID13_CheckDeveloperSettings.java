package com.viewQwest.app.scripts;

import com.viewQwest.app.context.CheckDeveloperSettingsContext;
import com.viewQwest.app.context.SettingsMenuContext;
import com.viewQwest.app.documents.CheckDeveloperSettingsDocument;
import com.viewQwest.app.documents.ClickSettingsButtonDocument;
import com.viewQwest.app.documents.SettingsMenuDocument;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.*;
import ru.yandex.qatools.allure.model.SeverityLevel;

public class SHDROID13_CheckDeveloperSettings extends Preconditions {
    @Features("Check developer settings page")
    @Step("Go to developer settings page and check settings configured")
    @Title("Check developer settings page")
    @Severity(SeverityLevel.CRITICAL)
    @Description("User should be able to access developer settings page without any errors..")
    @Stories({"Access developer page"})
    @Test
    public void deviceManage() throws Exception {

        new ClickSettingsButtonDocument().click();
        new SettingsMenuDocument(new SettingsMenuContext("Developer Settings")).click();
        byte[] screenshot = new CheckDeveloperSettingsDocument(new CheckDeveloperSettingsContext("button1")).click();
        saveScreenshot(screenshot);
    }
}

