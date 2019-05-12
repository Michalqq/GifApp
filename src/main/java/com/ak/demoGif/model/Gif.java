package com.ak.demoGif.model;

public class Gif {

    private String name;
    private String userName;
    private boolean favorites;
    private int categoryId;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

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

    public Gif(String name, boolean favorites, String userName, int categoryId) {
        this.name = name;
        this.favorites = favorites;
        this.userName = userName;
        this.categoryId = categoryId;
    }
}
