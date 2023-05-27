package me.snowlight.reservationmovie;

class TimeRule implements Rule {

    @Override
    public boolean isSatisfiedBy(DiscountCommand command) {
        return command.isDiscountTime();
    }
}
