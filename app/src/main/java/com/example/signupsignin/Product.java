package com.example.signupsignin;

public class Product {

    private String productName;
    private String proInfo;
    private String proCompany;
    private String proPrice;



    public Product() {
    }


    public Product(String productName, String proInfo, String proCompany, String proPrice) {
        this.productName =productName;
        this.proInfo = proInfo;
        this.proCompany = proCompany;
        this.proPrice =proPrice;
    }




    public String getProductName() { return productName; }
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProInfo() { return proInfo; }
    public void setProInfo(String proInfo) { this.proInfo = proInfo; }

    public String getProCompany() { return proCompany; }
    public void setProCompany(String proCompany) { this.proCompany = proCompany; }


    public String getProPrice() {
        return proPrice;
    }
    public void setProPrice(String proPrice) {
        this.proPrice = proPrice;
    }

    @Override
    public String toString() {
        return "MainPage{" +
                "productName='" + productName + '\'' +
                ",proInfo='" + proInfo+ '\'' +
                ",  proCompany='" +  proCompany + '\'' +
                ", proPrice=" + proPrice +
                '}';
    }
}
