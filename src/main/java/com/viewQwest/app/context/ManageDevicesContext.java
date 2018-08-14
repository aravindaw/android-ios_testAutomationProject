package com.viewQwest.app.context;

public class ManageDevicesContext {
    private String deviceName;

    public ManageDevicesContext(String deviceName) {
        this.deviceName=deviceName;

    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }
}
