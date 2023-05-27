package me.snowlight.reservationmovie;

import java.util.List;

class AmountDiscounter extends Discounter {
    private final Money discountMoney;

    public AmountDiscounter(Money discountMoney, List<Rule> rules) {
        this.discountMoney = discountMoney;
        this.rules = rules;
    }

    @Override
    protected Money getCalculateMoney(Money currentMoney) {
        return currentMoney.minus(discountMoney);
    }
}
