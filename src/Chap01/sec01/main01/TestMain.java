package Chap01.sec01.main01;

import java.util.Arrays;
import Chap01.sec01.main01.ProductVo.TableInfo;

public class TestMain {

    public static void main(String[] args) {
        System.out.println("ProductVO Header - " + Arrays.toString(TableInfo.HEADER_NAME_INFO));
        ProductVo v1 = new ProductVo("인삼차",9000);
        ProductVo v2 = new ProductVo("녹차",6000);
        System.out.println(v1.toString());
        System.out.println(v2.toString());
    }

}
