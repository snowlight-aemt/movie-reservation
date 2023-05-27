package me.snowlight.reservationmovie;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class RuleTest {
    @Test
    void satisfiedBy() {
        TimeRule timeRule = new TimeRule();
        LocalDateTime dateTime = LocalDateTime.of(2023, Month.MAY, 27, 9, 0);
        boolean sut = timeRule.isSatisfiedBy(new RuleCommand(dateTime));

        Assertions.assertTrue(sut);
    }

    @Test
    void no_satisfiedBy_() {
        TimeRule timeRule = new TimeRule();
        LocalDateTime dateTime = LocalDateTime.of(2023, Month.MAY, 27, 11, 0);
        boolean sut = timeRule.isSatisfiedBy(new RuleCommand(dateTime));

        Assertions.assertFalse(sut);
    }

    class TimeRule implements Rule {

        @Override
        public boolean isSatisfiedBy(RuleCommand command) {
            return command.isDiscountTime();
        }
    }

    public class RuleCommand {
        private LocalDateTime reservedAt;

        public RuleCommand(LocalDateTime reservedAt) {
            this.reservedAt = reservedAt;
        }

        public boolean isDiscountTime() {
            return reservedAt.toLocalTime().isBefore(LocalTime.of(10,0));
        }
    }
}
