package me.snowlight.reservationmovie;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.*;

public class ReservationTest {
    @Test
    void reserve() {
        ReservationService reservation = new ReservationService();

        List<Rule> rules = List.of(new TimeRule());
        AmountDiscounter discounter = new AmountDiscounter(new Money(10_000), rules);
        Movie movie = new Movie(discounter, new Money(20_000));

        LocalDateTime testDateTime = LocalDateTime.of(2023, 5, 28, 9, 0);
        ReservationCommand command = new ReservationCommand(testDateTime);


        String reserveToken = reservation.reserve(movie, command);
        Assertions.assertThat(reserveToken).isNotNull();

        Reservation sut = reservation.getReservationBy(reserveToken);
        Assertions.assertThat(sut).isNotNull();
        Assertions.assertThat(sut.getReservedAt()).isEqualTo(command.getReservedAt());
        Assertions.assertThat(sut.getPrice()).isEqualTo(new Money(10_000));
    }

    public static class ReservationService {
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
}
