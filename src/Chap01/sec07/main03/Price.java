package Chap01.sec07.main03;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;

import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(FIELD)
@Repeatable(Prices.class)
public @interface Price {
    public double value();
    public String currency();
    public String currencyName();
}
