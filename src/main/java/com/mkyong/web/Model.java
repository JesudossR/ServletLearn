package com.mkyong.web;



public class Model {
    private  int id;
    private String modelName;
    private int year;
    private int price;
    private String company;
    @Override
    public String toString() {
        return " [id=" + id + ", name=" + modelName + ", year =" + year + ", price =" + price + ", company =" + company+ "]";
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getModelName() {
        return modelName;
    }
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public Model(int id, String modelName, int year, int price, String company) {
        this.id = id;
        this.modelName = modelName;
        this.year = year;
        this.price = price;
        this.company = company;
    }

    public Model() {
        
    }
    
}

