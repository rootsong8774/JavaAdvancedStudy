package Chap01.sec07.main02;


import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(FIELD)
public @interface Anno1 {
    public String name();
    public int value();
    public Child child();
    public DataType dataType();
}
