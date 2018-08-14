package com.viewQwest.app.scripts;

import com.viewQwest.app.context.UserLoginContext;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.*;
import ru.yandex.qatools.allure.model.SeverityLevel;

public class SHDROID05_LoginWithInvalidEmailFormat extends StartDriver {
    @Features("User Login")
    @Step("Login with invalid username format and valid password")
    @Title("User Login Testing")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Give invalid username format and valid password and click login button. User should not be able to login to the system. Error message should displayed")
    @Stories({"Login Testing"})
    @Test
    public void loginWithValidUsernameAndPassword() throws Exception {
        UserLoginContext context = new UserLoginContext();
        context.setUserName("invalidFormat");
        context.setPassword("test123#");
        context.setState(false);
        new CheckDevice().run(context);
    }
}
