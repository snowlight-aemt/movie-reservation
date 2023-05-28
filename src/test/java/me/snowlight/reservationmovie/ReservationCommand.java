package me.snowlight.reservationmovie;

import java.time.LocalDateTime;

public class ReservationCommand {
    private LocalDateTime reservedAt;

    public ReservationCommand(LocalDateTime reservedAt) {
        this.reservedAt = reservedAt;
    }

    public LocalDateTime getReservedAt() {
        return reservedAt;
    }

    public DiscountCommand toDiscountCommand() {
        return new DiscountCommand(reservedAt);
    }
}
