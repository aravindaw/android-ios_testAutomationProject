package com.viewQwest.app.documents;

import com.viewQwest.app.context.CheckDeveloperSettingsContext;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.viewQwest.app.scripts.StartDriver.driver;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class CheckDeveloperSettingsDocument {
    private final CheckDeveloperSettingsContext context;

    public CheckDeveloperSettingsDocument(CheckDeveloperSettingsContext context) {
        this.context=context;
    }

    public byte[] click(){
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='Enter Raspberry IP']")));
        driver.findElement(By.id(context.getButton())).click();
        return driver.getScreenshotAs(OutputType.BYTES);
    }
}
