package Chap03.Exercise;

import java.util.Objects;

public record Trader(String name, String city) {

    @Override
    public String toString() {
        return "Trader:" + this.name + " in " + this.city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Trader trader = (Trader) o;
        return Objects.equals(name, trader.name) && Objects.equals(city,
            trader.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, city);
    }
}
