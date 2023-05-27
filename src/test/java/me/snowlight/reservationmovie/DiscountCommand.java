package me.snowlight.reservationmovie;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class DiscountCommand {
    private LocalDateTime reservedAt;

    public DiscountCommand(LocalDateTime reservedAt) {
        this.reservedAt = reservedAt;
    }

    public boolean isDiscountTime() {
        return reservedAt.toLocalTime().isBefore(LocalTime.of(10, 0));
    }
}
