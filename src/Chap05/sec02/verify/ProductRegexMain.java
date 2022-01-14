package Chap05.sec02.verify;

import java.util.Arrays;

public class ProductRegexMain {

    public static void main(String[] args) {
        String data = "EL-001**LG**Portable_Monitor**2****390000";
        String[] productInfo = data.split("[*]+");
        Arrays.stream(productInfo).forEach(System.out::println);
        Product product = new Product(productInfo[0], productInfo[1], productInfo[2],
            Integer.parseInt(productInfo[3]), Integer.parseInt(productInfo[4]));

        System.out.println(product);

    }

}
