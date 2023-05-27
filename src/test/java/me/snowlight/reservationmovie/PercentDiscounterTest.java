package me.snowlight.reservationmovie;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;

import java.util.List;

public class PercentDiscounterTest {
    @Test
    void calculate_no_rule() {
        Rule mockRule = BDDMockito.mock(Rule.class);
        BDDMockito.given(mockRule.isSatisfiedBy()).willReturn(false);
        List<Rule> rules = List.of(mockRule);

        Discounter discounter = new PercentDiscounter(0.1f, rules);

        Assertions.assertThat(discounter.discountMoney(new Money(10_000))).isEqualTo(new Money(10_000));
    }

    @Test
    void calculate() {
        Rule mockRule = BDDMockito.mock(Rule.class);
        BDDMockito.given(mockRule.isSatisfiedBy()).willReturn(true);
        List<Rule> rules = List.of(mockRule);

        Discounter discounter = new PercentDiscounter(0.1f, rules);

        Money actual = discounter.discountMoney(new Money(10_000));
        Assertions.assertThat(actual).isEqualTo(new Money(9_000));
    }
}
