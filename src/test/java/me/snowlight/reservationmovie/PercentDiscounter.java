package me.snowlight.reservationmovie;

import java.util.List;

public class PercentDiscounter implements Discounter {

    private final float percent;
    private final List<Rule> rules;

    public PercentDiscounter(float percent, List<Rule> rules) {
        this.percent = percent;
        this.rules = rules;
    }

    @Override
    public Money discountMoney(Money currentMoney) {
        for (Rule rule : rules) {
            if (rule.isSatisfiedBy()) {
                return currentMoney.minus(currentMoney.times(percent));
            }
        }

        return currentMoney;
    }
}
