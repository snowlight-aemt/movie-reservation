package me.snowlight.reservationmovie;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

public class ShowingServiceTest {
    private final Movie movie = Mockito.mock(Movie.class);

    @Test
    void reserve() {
        ShowingService showingService = new ShowingService();
        ReservationResult reservationResult =  showingService.reserve(movie);

        Assertions.assertThat(reservationResult).isEqualTo(ReservationResult.SUCCESS);
    }

    @Test
    void reserve_without_movie() {
        ShowingService showingService = new ShowingService();
        BDDMockito.willThrow(new RuntimeException("!"))
                    .given(movie).calculatePrice();

        ReservationResult result = showingService.reserve(movie);
        Assertions.assertThat(result).isEqualTo(ReservationResult.MOVIE_CALCULATE_EXCEPTION);
    }

    private class Movie {
        public Integer calculatePrice() {
            return null;
        }
    }

    private class ShowingService {
        public ReservationResult reserve(Movie movie) {
            try {
                movie.calculatePrice();
            } catch (Exception e) {
                return ReservationResult.MOVIE_CALCULATE_EXCEPTION;
            }

            return ReservationResult.SUCCESS;
        }
    }

    private enum ReservationResult {
        MOVIE_CALCULATE_EXCEPTION, SUCCESS
    }
}
