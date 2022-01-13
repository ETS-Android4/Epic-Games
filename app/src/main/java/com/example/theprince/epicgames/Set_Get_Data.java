package com.example.theprince.epicgames;

public class Set_Get_Data {

    private String name;
    private String price;
    private String text;
    private int image;

    Set_Get_Data(String name ,String text ,String price  ,int image){
        this.name = name;
        this.price = price;
        this.text = text;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

}
