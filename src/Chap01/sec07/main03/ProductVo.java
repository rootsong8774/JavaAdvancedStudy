package Chap01.sec07.main03;

public class ProductVo {
    private String productNo;
    private String productName;
    @Prices({
        @Price(value = 10.19, currencyName = "Yen", currency ="JPY" ),
        @Price(value = 1142.50, currencyName = "Dollar", currency ="USD" )
    })
    private int price;

    public ProductVo(String productNo, String productName, int price) {
        this.productNo = productNo;
        this.productName = productName;
        this.price = price;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
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
}
