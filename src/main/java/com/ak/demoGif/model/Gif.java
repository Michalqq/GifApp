package com.ak.demoGif.model;

public class Gif {

    private String name;
    private String userName;
    private boolean favorites;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFavorites() {
        return favorites;
    }

    public void setFavorites(boolean favorites) {
        this.favorites = favorites;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Gif(String name, boolean favorites, String userName) {
        this.name = name;
        this.favorites = favorites;
        this.userName = userName;
    }
}
