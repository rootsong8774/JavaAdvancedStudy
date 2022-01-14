package Chap05.sec02.verify;

public class Product {

    private String productId;
    private String maker;
    private String name;
    private int amount;
    private int price;

    public Product(String productId, String maker, String name, int amount, int price) {
        this.productId = productId;
        this.maker = maker;
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "[" + productId + "," + maker + "," + name + "," + amount + "," + price + ']';
    }
}
