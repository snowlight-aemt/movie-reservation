package me.snowlight.reservationmovie;

import java.util.List;

class AmountDiscounter implements Discounter {
    private final List<Rule> rules;
    private final Money discountMoney;

    public AmountDiscounter(Money discountMoney, List<Rule> rules) {
        this.discountMoney = discountMoney;
        this.rules = rules;
    }

    @Override
    public Money discountMoney(Money currentMoney) {
        for (Rule rule : this.rules) {
            if (rule.isSatisfiedBy()) {
                return currentMoney.minus(discountMoney);
            }
        }
        return currentMoney;
    }
}
