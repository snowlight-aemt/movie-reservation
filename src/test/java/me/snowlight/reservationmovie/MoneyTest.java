package me.snowlight.reservationmovie;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MoneyTest {
    @Test
    void minus() {
        Money money = new Money(10_000);
        Money sut = money.minus(new Money(5_000));

        Assertions.assertThat(sut).isEqualTo(new Money(5_000));
    }

    @Test
    void minus2() {
        Money money = new Money(5_000);
        Money sut = money.minus(new Money(5_000));

        Assertions.assertThat(sut).isEqualTo(new Money(0));
    }

    @Test
    void times() {
        Money money = new Money(10_000);
        Money sut = money.times(0.1f);

        Money expected = new Money((int) (10_000 * 0.1));
        Assertions.assertThat(sut).isEqualTo(expected);
    }
}
