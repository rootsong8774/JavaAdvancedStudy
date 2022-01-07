package Chap01.sec07.main01;

public class ProductVo {
    @Grid(name = "품목번호", width = 100, order = 1)
    private String productNo;
    @Grid(name = "품목명", width = 400, order = 2)
    private String productName;
    @Grid(name = "단가", width = 200, order = 3)
    private int price;

    public ProductVo(String productNo, String productName, int price) {
        this.productNo = productNo;
        this.productName = productName;
        this.price = price;
    }
}
