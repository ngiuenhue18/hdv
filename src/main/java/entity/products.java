/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Tran Hieu
 */
public class products {
    private int id;
    private String catalogue;
    private String msp;
    private String type;
    private String product_name;
    private String product_img;
    private double product_price;
    private String product_description;  
    public products() {
        
    }

    public products(int id, String catalogue, String msp, String type, String product_name, String product_img, double product_price, String product_description) {
        this.id = id;
        this.catalogue = catalogue;
        this.msp = msp;
        this.type = type;
        this.product_name = product_name;
        this.product_img = product_img;
        this.product_price = product_price;
        this.product_description = product_description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCatalogue() {
        return catalogue;
    }

    public void setCatalogue(String catalogue) {
        this.catalogue = catalogue;
    }

    public String getMsp() {
        return msp;
    }

    public void setMsp(String msp) {
        this.msp = msp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_img() {
        return product_img;
    }

    public void setProduct_img(String product_img) {
        this.product_img = product_img;
    }

    public double getProduct_price() {
        return product_price;
    }

    public void setProduct_price(double product_price) {
        this.product_price = product_price;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    @Override
    public String toString() {
        return "products{" + "id=" + id + ", catalogue=" + catalogue + ", maSP=" + msp + ", type=" + type + ", product_name=" + product_name + ", product_img=" + product_img + ", product_price=" + product_price + ", product_description=" + product_description + '}';
    }
    
    
}
