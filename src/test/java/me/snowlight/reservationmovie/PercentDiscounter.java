package me.snowlight.reservationmovie;

import java.util.List;

public class PercentDiscounter extends Discounter {
    private final float percent;

    public PercentDiscounter(float percent, List<Rule> rules) {
        this.percent = percent;
        this.rules = rules;
    }

    @Override
    protected Money getCalculateMoney(Money currentMoney) {
        return currentMoney.minus(currentMoney.times(percent));
    }
}
