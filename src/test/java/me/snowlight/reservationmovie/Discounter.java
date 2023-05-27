package me.snowlight.reservationmovie;

import java.util.List;

public abstract class Discounter {
    protected List<Rule> rules;

    public Money discountMoney(Money currentMoney) {
        for (Rule rule : this.rules) {
            if (rule.isSatisfiedBy()) {
                return getCalculateMoney(currentMoney);
            }
        }
        return currentMoney;
    }

    protected abstract Money getCalculateMoney(Money currentMoney);
}
