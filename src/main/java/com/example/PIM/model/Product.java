package com.example.PIM.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Products")
public class Product {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int productid;
    public String producttitle;
    public String productdescription;
    public int productprice;
    public int productdiscount;
    public String productimage;
    public LocalDateTime createdat;
    public LocalDateTime updatedat;


    @ManyToOne
    @JoinColumn(name = "companyid")
    private Company company;

    public Product() {
    }

    public Product(int productid, String producttitle, String productdescription, int productprice, int productdiscount, String productimage, LocalDateTime createdat, LocalDateTime updatedat, Company company) {
        this.productid = productid;
        this.producttitle = producttitle;
        this.productdescription = productdescription;
        this.productprice = productprice;
        this.productdiscount = productdiscount;
        this.productimage = productimage;
        this.createdat = createdat;
        this.updatedat = updatedat;
        this.company = company;
    }

    public Product(String producttitle, String productdescription, int productprice, int productdiscount, String productimage, LocalDateTime createdat, LocalDateTime updatedat, Company company) {
        this.productid = productid;
        this.producttitle = producttitle;
        this.productdescription = productdescription;
        this.productprice = productprice;
        this.productdiscount = productdiscount;
        this.productimage = productimage;
        this.createdat = createdat;
        this.updatedat = updatedat;
        this.company = company;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productid=" + productid +
                ", producttitle='" + producttitle + '\'' +
                ", productdescription='" + productdescription + '\'' +
                ", productprice=" + productprice +
                ", productdiscount=" + productdiscount +
                ", productimage='" + productimage + '\'' +
                ", createdat=" + createdat +
                ", updatedat=" + updatedat +
                ", company=" + company +
                '}';
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public String getProducttitle() {
        return producttitle;
    }

    public void setProducttitle(String producttitle) {
        this.producttitle = producttitle;
    }

    public String getProductdescription() {
        return productdescription;
    }

    public void setProductdescription(String productdescription) {
        this.productdescription = productdescription;
    }

    public int getProductprice() {
        return productprice;
    }

    public void setProductprice(int productprice) {
        this.productprice = productprice;
    }

    public int getProductdiscount() {
        return productdiscount;
    }

    public void setProductdiscount(int productdiscount) {
        this.productdiscount = productdiscount;
    }

    public String getProductimage() {
        return productimage;
    }

    public void setProductimage(String productimage) {
        this.productimage = productimage;
    }

    public LocalDateTime getCreatedat() {
        return createdat;
    }

    public void setCreatedat(LocalDateTime createdat) {
        this.createdat = createdat;
    }

    public LocalDateTime getUpdatedat() {
        return updatedat;
    }

    public void setUpdatedat(LocalDateTime updatedat) {
        this.updatedat = updatedat;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
