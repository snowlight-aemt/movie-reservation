package me.snowlight.reservationmovie;

import java.util.List;

public abstract class Discounter {
    protected List<Rule> rules;

    public Money discountMoney(Money currentMoney, DiscountCommand command) {
        for (Rule rule : this.rules) {
            if (rule.isSatisfiedBy(command)) {
                return getCalculateMoney(currentMoney);
            }
        }
        return currentMoney;
    }

    protected abstract Money getCalculateMoney(Money currentMoney);
}
