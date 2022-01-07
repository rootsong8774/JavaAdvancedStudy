package Chap01.sec07.main02;

import java.lang.reflect.Field;
import java.util.Arrays;

public class TestMain {

    public static void main(String[] args) throws Exception {
        Class<ProductVo> voClass = ProductVo.class;

        Field field1 = voClass.getDeclaredField("productNo");
        Anno1 anno1 = field1.getAnnotation(Anno1.class);
        System.out.println("name : "+ anno1.name());
        System.out.println("value : "+ anno1.value());
        System.out.println("child : "+ anno1.child().value());
        System.out.println("dataType : "+ anno1.dataType());

        System.out.println("==============================");

        Field field2 = voClass.getDeclaredField("productName");
        Anno2 anno2 = field2.getAnnotation(Anno2.class);
        System.out.println("name : "+ Arrays.toString(anno2.names()));
        System.out.println("value : "+ Arrays.toString(anno2.values()));

        System.out.println("dataType : "+ Arrays.toString(anno2.dataTypes()));

        for(Child c: anno2.children()){
            System.out.println("child : "+c.value());
        }

    }

}
