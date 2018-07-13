package com.developer.dinhduy.sliderproejct;

class IconX {
    private String text;
    private int Picture;

    public IconX() {
    }

    public IconX(String text, int picture) {

        this.text = text;
        Picture = picture;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getPicture() {
        return Picture;
    }

    public void setPicture(int picture) {
        Picture = picture;
    }
}
