package mate.academy.spring.controller;

import mate.academy.spring.model.dto.MovieRequestDto;
import mate.academy.spring.model.dto.MovieResponseDto;
import mate.academy.spring.service.MovieService;
import mate.academy.spring.service.dto.mapper.MovieMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {
    private final MovieService movieService;
    private final MovieMapper movieMapper;

    public MovieController(MovieService movieService,
                           MovieMapper movieMapper) {
        this.movieService = movieService;
        this.movieMapper = movieMapper;
    }

    @GetMapping("/movies/{id}")
    public MovieResponseDto get(@PathVariable Long id) {
        return movieMapper.toDto(movieService.get(id));
    }

    @PostMapping("/movies")
    public MovieResponseDto get(@RequestBody MovieRequestDto movieRequestDto) {
        return movieMapper.toDto(movieService.add(movieMapper.toModel(movieRequestDto)));
    }
}
