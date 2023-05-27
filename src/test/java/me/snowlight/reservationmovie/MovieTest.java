package me.snowlight.reservationmovie;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

public class MovieTest {
    Discounter discounter = Mockito.mock(Discounter.class);
    Movie movie = new Movie(discounter, new Money(5_000));

    @Test
    void calculatePrice() {
        BDDMockito.willThrow(DiscountException.class)
                    .given(discounter).discountMoney(Mockito.any(Money.class));

        Assertions.assertThatCode(() -> movie.calculatePrice())
                    .isInstanceOf(RuntimeException.class);
    }

    public interface Discounter {
        Money discountMoney(Money money);
    }

    private class DiscountException extends RuntimeException {
    }
}
