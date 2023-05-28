package me.snowlight.reservationmovie;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {
    @DisplayName("Money 더하기 메스드 추가 - 1")
    @Test
    void minus() {
        Money money = new Money(10_000);
        Money sut = money.minus(new Money(5_000));

        Assertions.assertThat(sut).isEqualTo(new Money(5_000));
    }

    @DisplayName("Money 더하기 메스드 추가 - 2")
    @Test
    void minus2() {
        Money money = new Money(5_000);
        Money sut = money.minus(new Money(5_000));

        Assertions.assertThat(sut).isEqualTo(new Money(0));
    }

    @DisplayName("Money 곱셉 메스드 추가 - 2")
    @Test
    void times() {
        Money money = new Money(10_000);
        Money sut = money.times(0.1f);

        Money expected = new Money((int) (10_000 * 0.1));
        Assertions.assertThat(sut).isEqualTo(expected);
    }
}
