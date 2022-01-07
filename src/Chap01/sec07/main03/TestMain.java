package Chap01.sec07.main03;

import java.lang.reflect.Field;

public class TestMain {

    public static void main(String[] args) {
        ProductVo p = new ProductVo("A001","Ginseng Latte", 9000);
        try {
            Field field = ProductVo.class.getDeclaredField("price");
            Prices prices = field.getAnnotation(Prices.class);
            Price[] types = prices.value();
            for(Price price: types){
                System.out.println("[Annotation Info] ::: "+price);
                double value = price.value();
                String nation = price.currency();
                String unitName = price.currencyName();
                double price2 = 1.0 * p.getPrice()/value;
                price2 = (int) (price2* 100 +0.5)/100.0;
                System.out.println(nation + " : "+price2+ " "+unitName);
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
