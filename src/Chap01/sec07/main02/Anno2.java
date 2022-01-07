package Chap01.sec07.main02;


import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(FIELD)
public @interface Anno2 {
    public String[] names();
    public int[] values();
    public Child[] children();
    public DataType[] dataTypes();

}
