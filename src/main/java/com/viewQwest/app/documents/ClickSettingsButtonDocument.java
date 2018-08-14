package com.viewQwest.app.documents;

import static com.viewQwest.app.scripts.StartDriver.driver;

public class ClickSettingsButtonDocument {
    public void click(){
        driver.findElementById("button_setting_menu").click();
    }
}
