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

    interface Rule {
        boolean isSatisfiedBy();
    }

    static class AmountDiscounter implements Discounter {
        private final List<Rule> rules;
        private final Money discountMoney;

        public AmountDiscounter(Money discountMoney, List<Rule> rules) {
            this.discountMoney = discountMoney;
            this.rules = rules;
        }

        @Override
        public Money discountMoney() {
            for (Rule rule : this.rules) {
                if (rule.isSatisfiedBy()) {
                    return discountMoney;
                }
            }
            return new Money(0);
        }
    }
}
