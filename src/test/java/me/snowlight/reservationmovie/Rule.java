package me.snowlight.reservationmovie;

interface Rule {
    boolean isSatisfiedBy(RuleTest.RuleCommand command);
}
