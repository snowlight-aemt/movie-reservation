package me.snowlight.reservationmovie;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;

public class RuleTest {
    @DisplayName("할인 규칙을 만족하는 경우")
    @Test
    void satisfiedBy() {
        TimeRule timeRule = new TimeRule();
        LocalDateTime dateTime = LocalDateTime.of(2023, Month.MAY, 27, 9, 0);
        boolean sut = timeRule.isSatisfiedBy(new DiscountCommand(dateTime));

        Assertions.assertTrue(sut);
    }

    @DisplayName("할인 규칙을 만족하는 않는 경우")
    @Test
    void no_satisfiedBy_() {
        TimeRule timeRule = new TimeRule();
        LocalDateTime dateTime = LocalDateTime.of(2023, Month.MAY, 27, 11, 0);
        boolean sut = timeRule.isSatisfiedBy(new DiscountCommand(dateTime));

        Assertions.assertFalse(sut);
    }

}
