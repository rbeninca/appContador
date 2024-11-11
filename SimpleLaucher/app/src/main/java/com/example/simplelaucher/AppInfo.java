package com.example.simplelaucher;

import android.graphics.drawable.Drawable;

public class AppInfo {
    private String name;
    private String packageName;
    private Drawable icon;
    private boolean isSystemApp;
    private boolean isLaunchable;


    public AppInfo(String name, String packageName, Drawable icon, boolean isSystemApp, boolean isLaunchable) {
        this.name = name;
        this.packageName = packageName;
        this.icon = icon;
        this.isSystemApp = isSystemApp;
        this.isLaunchable = this.isLaunchable;
    }

    public String getName() {
        return name;
    }

    public String getPackageName() {
        return packageName;
    }

    public Drawable getIcon() {
        return icon;
    }

    public boolean isSystemApp() {
        return isSystemApp;
    }
    public boolean isLaunchable() {
        return isLaunchable;
    }
}
