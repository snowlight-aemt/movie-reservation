package me.snowlight.reservationmovie;

import java.time.LocalDateTime;

public class Reservation {
    private final LocalDateTime ReservedAt;
    private final Money price;

    public Reservation(LocalDateTime reservedAt, Money price) {
        this.ReservedAt = reservedAt;
        this.price = price;
    }

    public LocalDateTime getReservedAt() {
        return ReservedAt;
    }

    public Money getPrice() {
        return price;
    }
}
