package me.snowlight.reservationmovie;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import java.util.List;

public class PercentDiscounterTest {
    @Test
    void calculate_no_rule() {
        Rule mockRule = BDDMockito.mock(Rule.class);
        BDDMockito.given(mockRule.isSatisfiedBy(Mockito.any(DiscountCommand.class))).willReturn(false);
        List<Rule> rules = List.of(mockRule);

        Discounter discounter = new PercentDiscounter(0.1f, rules);

        Assertions.assertThat(discounter.discountMoney(new Money(10_000), new DiscountCommand(null))).isEqualTo(new Money(10_000));
    }

    @Test
    void calculate() {
        Rule mockRule = BDDMockito.mock(Rule.class);
        BDDMockito.given(mockRule.isSatisfiedBy(Mockito.any(DiscountCommand.class))).willReturn(true);
        List<Rule> rules = List.of(mockRule);

        Discounter discounter = new PercentDiscounter(0.1f, rules);

        Money actual = discounter.discountMoney(new Money(10_000), new DiscountCommand(null));
        Assertions.assertThat(actual).isEqualTo(new Money(9_000));
    }
}
