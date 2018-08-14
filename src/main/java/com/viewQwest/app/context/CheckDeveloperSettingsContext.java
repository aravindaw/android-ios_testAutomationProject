package com.viewQwest.app.context;

public class CheckDeveloperSettingsContext {
    private String button;

    public String getButton() {
        return button;
    }

    public void setButton(String button) {
        this.button = button;
    }

    public CheckDeveloperSettingsContext(String button) {
        this.button=button;
    }
}
