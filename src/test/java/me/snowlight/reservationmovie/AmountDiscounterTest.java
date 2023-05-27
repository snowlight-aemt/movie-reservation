package me.snowlight.reservationmovie;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import java.util.List;

public class AmountDiscounterTest {
    @Test
    void calculate_no_rule() {
        Rule mockRule = BDDMockito.mock(Rule.class);
        BDDMockito.given(mockRule.isSatisfiedBy(Mockito.any(RuleTest.RuleCommand.class))).willReturn(false);
        List<Rule> rules = List.of(mockRule);

        Discounter discounter = new AmountDiscounter(new Money(10_000), rules);

        Assertions.assertThat(discounter.discountMoney(new Money(10_000))).isEqualTo(new Money(10_000));
    }

    @Test
    void calculate() {
        Rule mockRule = BDDMockito.mock(Rule.class);
        BDDMockito.given(mockRule.isSatisfiedBy(Mockito.any(RuleTest.RuleCommand.class))).willReturn(true);
        List<Rule> rules = List.of(mockRule);

        Discounter discounter = new AmountDiscounter(new Money(5_000), rules);

        Assertions.assertThat(discounter.discountMoney(new Money(5_000))).isEqualTo(new Money(0));
    }

}
