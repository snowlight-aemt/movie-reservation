package me.snowlight.reservationmovie;

interface Rule {
    boolean isSatisfiedBy(DiscountCommand command);
}
