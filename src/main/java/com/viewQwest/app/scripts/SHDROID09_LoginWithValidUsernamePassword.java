package com.viewQwest.app.scripts;

import com.viewQwest.app.context.UserLoginContext;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.*;
import ru.yandex.qatools.allure.model.SeverityLevel;

public class SHDROID09_LoginWithValidUsernamePassword extends StartDriver {
//    private AppiumDriver driver;

    @Features("User Login")
    @Step("Login with valid username and valid password")
    @Title("User Login Testing")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Give valid username and valid password and click login button. User should be able to login to the system")
    @Stories({"Login Testing"})
    @Test
    public void loginWithValidUsernameAndPassword() throws Exception {
        UserLoginContext context = new UserLoginContext();
        context.setUserName("vqsmsubprimary@mailinator.com");
        context.setPassword("test123#");
        context.setState(true);
        new CheckDevice().run(context);
    }
}