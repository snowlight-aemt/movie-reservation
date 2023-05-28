package me.snowlight.reservationmovie;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import java.time.LocalDateTime;

public class ShowingServiceTest {
    private final Movie movie = Mockito.mock(Movie.class);

    @DisplayName("예매 테스트")
    @Test
    void reserve() {
        ShowingService showingService = new ShowingService();
        ReservationResult reservationResult =  showingService.reserve(movie, new ReservationCommand(LocalDateTime.now()));

        Assertions.assertThat(reservationResult).isEqualTo(ReservationResult.SUCCESS);
    }

    @DisplayName("예매 테스트 - 할인 계산에 실패한 경우")
    @Test
    void reserve_without_movie() {
        ShowingService showingService = new ShowingService();
        BDDMockito.willThrow(new RuntimeException("!"))
                    .given(movie).calculatePrice(Mockito.any(ReservationCommand.class));

        ReservationResult result = showingService.reserve(movie, new ReservationCommand(LocalDateTime.now()));
        Assertions.assertThat(result).isEqualTo(ReservationResult.MOVIE_CALCULATE_EXCEPTION);
    }

}
