package com.viewQwest.app.context;

public class SettingsMenuContext {
    private String selectFromMenu;

    public SettingsMenuContext(String selectFromMenu) {
        this.selectFromMenu = selectFromMenu;
    }

    public String getSelectFromMenu() {
        return selectFromMenu;
    }

    public void setSelectFromMenu(String selectFromMenu) {
        this.selectFromMenu = selectFromMenu;
    }
}
