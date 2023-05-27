package me.snowlight.reservationmovie;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

public class MovieTest {
    Discounter discounter = Mockito.mock(Discounter.class);
    Money movieFee = new Money(5_000);
    Movie movie = new Movie(discounter, movieFee);

    @Test
    void calculatePrice() {
        BDDMockito.willThrow(DiscountException.class)
                    .given(discounter).discountMoney();

        Assertions.assertThatCode(() -> movie.calculatePrice())
                    .isInstanceOf(RuntimeException.class);
    }

    @Test
    void calculatePrice_success() {
        Money monkeyDiscounted = new Money(1_000);
        BDDMockito.given(discounter.discountMoney()).willReturn(monkeyDiscounted);

        Money sut = movie.calculatePrice();
        Assertions.assertThat(sut).isEqualTo(movieFee.minus(monkeyDiscounted));
    }
}
