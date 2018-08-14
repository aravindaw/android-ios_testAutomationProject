package com.viewQwest.app.scripts;

import com.viewQwest.app.context.UserLoginContext;
import com.viewQwest.app.documents.UserLoginDocument;
import com.viewQwest.app.documents.UserLoginDocument_IOS;
import ru.yandex.qatools.allure.annotations.Attachment;

import static com.viewQwest.app.scripts.StartDriver.device;

class CheckDevice {
    void run(UserLoginContext context) throws Exception {
//        UserLoginContext context = new UserLoginContext();
        if (device.equals(Enums.ANDROID)) {
            UserLoginDocument userLoginDocument = new UserLoginDocument(context);
            byte[] screenshot = userLoginDocument.login();
            saveScreenshot(screenshot);
        } else {
            UserLoginDocument_IOS userLoginDocument = new UserLoginDocument_IOS(context);
            byte[] screenshot = userLoginDocument.login();
            saveScreenshot(screenshot);
        }
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }
}
