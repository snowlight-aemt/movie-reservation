package me.snowlight.reservationmovie;

import java.util.Objects;

public class Money {
    private final int amount;

    public Money(int amount) {
        this.amount = amount;
    }

    public Money minus(Money money) {
        return new Money(this.amount - money.amount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return amount == money.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    public Money times(float value) {
        return new Money((int) (amount * value));
    }
}
