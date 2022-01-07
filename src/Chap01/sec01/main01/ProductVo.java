package Chap01.sec01.main01;

public class ProductVo {

    public enum DataType {
        INSERT, UPDATE, DELETE, NORMAL
    }

    public static class TableInfo {

        public static final String[] HEADER_NAME_INFO = new String[]{"PRODUCT_NO", "PRODUCT_NAME",
            "PRICE", "STATUS"};
        public static final int[] WIDTH_INFO = {100, 400, 100, 80};
    }

    private static int count;

    static {
        System.out.println("ProductVo - static initialize");
    }

    {
        count++;
        System.out.println("ProductVo - Static initialize count[" + count + "]");
        if (count < 10) {
            this.productNo = "A00" + count;
        } else if (count < 100) {
            this.productNo = "A0" + count;
        } else {
            this.productNo = "A" + count;
        }

        System.out.println("ProductVo - productNo[" + this.productNo + "]");
    }

    private String productNo;
    private String productName;
    private int price;

    public ProductVo() {
        System.out.println("ProductVo Constructor");
    }

    public ProductVo(String productName, int price) {
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

    @Override
    public String toString() {
        return this.productNo + " : " + this.productName + " : " + this.price;
    }

    public String[] getData() {

        return new String[]{this.productNo, this.productName, String.valueOf(this.price)};
    }


}
