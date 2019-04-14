package com.example.gamelistactivity;

import android.graphics.drawable.Drawable;

public class Game {
    private String name;
    private String Version;
    boolean chacked;
    private Drawable image;

    public Game(String name, String version, boolean chacked, Drawable image) {
        this.name = name;
        Version = version;
        this.chacked = chacked;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return Version;
    }

    public void setVersion(String version) {
        Version = version;
    }

    public boolean isChacked() {
        return chacked;
    }

    public void setChacked(boolean chacked) {
        this.chacked = chacked;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }
}
