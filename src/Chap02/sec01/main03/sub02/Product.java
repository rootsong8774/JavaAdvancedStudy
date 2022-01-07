package Chap02.sec01.main03.sub02;

public class Product {

    private String productId;
    private String productName;
    private int price;

    public Product(String productId, String productName, int price) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product" + " [" +
            "productId='" + productId + '\'' +
            ", productName='" + productName + '\'' +
            ", price=" + price +
            ']';
    }
}
