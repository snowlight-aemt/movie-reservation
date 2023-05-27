package me.snowlight.reservationmovie;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;

import java.util.List;

public class DiscounterTest {
    @Test
    void calculate_no_rule() {
        Rule mockRule = BDDMockito.mock(Rule.class);
        BDDMockito.given(mockRule.isSatisfiedBy()).willReturn(false);
        List<Rule> rules = List.of(mockRule);

        Discounter discounter = new AmountDiscounter(new Money(10_000), rules);

        Assertions.assertThat(discounter.discountMoney()).isEqualTo(new Money(0));
    }

    @Test
    void calculate() {
        Rule mockRule = BDDMockito.mock(Rule.class);
        BDDMockito.given(mockRule.isSatisfiedBy()).willReturn(true);
        List<Rule> rules = List.of(mockRule);

        Discounter discounter = new AmountDiscounter(new Money(10_000), rules);

        Assertions.assertThat(discounter.discountMoney()).isEqualTo(new Money(10_000));
    }

}
