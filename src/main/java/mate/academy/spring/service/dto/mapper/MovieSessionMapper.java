package mate.academy.spring.service.dto.mapper;

import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.Movie;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.MovieSessionRequestDto;
import mate.academy.spring.model.dto.MovieSessionResponseDto;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.MovieService;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionMapper {
    private final MovieService movieService;
    private final CinemaHallService cinemaHallService;

    public MovieSessionMapper(MovieService movieService, CinemaHallService cinemaHallService) {
        this.movieService = movieService;
        this.cinemaHallService = cinemaHallService;
    }

    public MovieSessionResponseDto toDto(MovieSession movieSession) {
        MovieSessionResponseDto sessionResponseDto = new MovieSessionResponseDto();
        sessionResponseDto.setId(movieSession.getId());
        sessionResponseDto.setMovieId(movieSession.getMovie().getId());
        sessionResponseDto.setCinemaHallId(movieSession.getCinemaHall().getId());
        sessionResponseDto.setShowTime(movieSession.getShowTime());
        return sessionResponseDto;
    }

    public MovieSession toModel(MovieSessionRequestDto sessionRequestDto) {
        MovieSession movieSession = new MovieSession();
        movieSession.setShowTime(sessionRequestDto.getShowTime());
        movieSession.setMovie(new Movie(sessionRequestDto.getCinemaHallId()));
        movieSession.setCinemaHall(new CinemaHall(sessionRequestDto.getCinemaHallId()));
        return movieSession;
    }
}
