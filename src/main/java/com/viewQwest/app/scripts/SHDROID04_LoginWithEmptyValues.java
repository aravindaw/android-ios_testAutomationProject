package com.viewQwest.app.scripts;

import com.viewQwest.app.context.UserLoginContext;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.*;
import ru.yandex.qatools.allure.model.SeverityLevel;

public class SHDROID04_LoginWithEmptyValues extends StartDriver {
    @Features("User Login")
    @Step("Login with empty username and empty password")
    @Title("User Login Testing")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Give empty username and empty password and click login button. User should not be able to login to the system. Error message should displayed")
    @Stories({"Login Testing"})
    @Test
    public void loginWithValidUsernameAndPassword() throws Exception {
        UserLoginContext context = new UserLoginContext();
        context.setUserName("");
        context.setPassword("");
        context.setState(false);
        new CheckDevice().run(context);
    }
}
