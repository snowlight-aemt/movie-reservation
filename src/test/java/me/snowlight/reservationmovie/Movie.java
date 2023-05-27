package me.snowlight.reservationmovie;

class Movie {
    private final Discounter discounter;
    private final Money money;

    public Movie(Discounter discounter, Money money) {

        this.discounter = discounter;
        this.money = money;
    }

    public Money calculatePrice() {
        return this.money.minus(discounter.discountMoney());
    }
}
