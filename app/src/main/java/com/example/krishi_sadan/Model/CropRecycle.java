package com.example.krishi_sadan.Model;

public class CropRecycle {

    int image;

    public CropRecycle(int image, String name) {
        this.image = image;
        this.name = name;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }
}
