package me.snowlight.reservationmovie;

class Movie {
    private final MovieTest.Discounter discounter;
    private final Money money;

    public Movie(MovieTest.Discounter discounter, Money money) {

        this.discounter = discounter;
        this.money = money;
    }

    public Money calculatePrice() {
        return discounter.discountMoney(this.money);
    }
}
