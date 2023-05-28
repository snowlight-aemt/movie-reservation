package me.snowlight.reservationmovie;

class ShowingService {
    public ReservationResult reserve(Movie movie, ReservationCommand command) {
        try {
            ReservationTest.ReservationService reservationService = new ReservationTest.ReservationService();
            reservationService.reserve(movie, command);

//            movie.calculatePrice(command);
        } catch (Exception e) {
            return ReservationResult.MOVIE_CALCULATE_EXCEPTION;
        }

        return ReservationResult.SUCCESS;
    }
}
