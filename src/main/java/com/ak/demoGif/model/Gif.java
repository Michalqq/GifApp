package com.ak.demoGif.model;

public class Gif {

    private String name;
    private boolean isFavourite;
    private String userName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFavourite() {
        return isFavourite;
    }

    public void setFavourite(boolean favourite) {
        isFavourite = favourite;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Gif(String name, boolean isFavourite, String userName) {
        this.name = name;
        this.isFavourite = isFavourite;
        this.userName = userName;
    }
}
