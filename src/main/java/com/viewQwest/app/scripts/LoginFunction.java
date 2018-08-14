package com.viewQwest.app.scripts;

import com.viewQwest.app.context.UserLoginContext;
import com.viewQwest.app.documents.UserLoginDocument;
import com.viewQwest.app.documents.UserLoginDocument_IOS;
import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.PropertiesConfiguration;

import static com.viewQwest.app.scripts.StartDriver.device;

class LoginFunction {
    void loginWithValidUsernameAndPassword() throws Exception {
        CompositeConfiguration config = new CompositeConfiguration();
        config.addConfiguration(new PropertiesConfiguration("src/main/resources/config.properties"));
        UserLoginContext context = new UserLoginContext();
        context.setUserName(config.getProperty("APP_VALID_USER_NAME").toString().trim());
        context.setPassword(config.getProperty("APP_VALID_USER_PASSWORD").toString().trim());
        context.setState(true);


        if (device.equals(Enums.ANDROID)){
            UserLoginDocument userLoginDocument = new UserLoginDocument(context);
            userLoginDocument.login();
        }
        else {
            UserLoginDocument_IOS userLoginDocument = new UserLoginDocument_IOS(context);
            userLoginDocument.login();
        }
    }
}
