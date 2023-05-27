package me.snowlight.reservationmovie;

class ShowingService {
    public ReservationResult reserve(Movie movie) {
        try {
            movie.calculatePrice();
        } catch (Exception e) {
            return ReservationResult.MOVIE_CALCULATE_EXCEPTION;
        }

        return ReservationResult.SUCCESS;
    }
}
