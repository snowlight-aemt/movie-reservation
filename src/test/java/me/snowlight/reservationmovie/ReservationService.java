package me.snowlight.reservationmovie;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ReservationService {
    Map<String, Reservation> reservations = new HashMap<>();

    public String reserve(Movie movie, ReservationCommand command) {
        String token = "res_" + UUID.randomUUID();
        reservations.put(token, new Reservation(command.getReservedAt(), movie.calculatePrice(command)));
        return token;
    }

    public Reservation getReservationBy(String reserveToken) {
        return reservations.get(reserveToken);
    }
}
