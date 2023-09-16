package com.gaurav.workshop.service.impl;

import com.gaurav.workshop.dto.MovieCreateRequest;
import com.gaurav.workshop.dto.MovieModifyRequest;
import com.gaurav.workshop.dto.MovieResponse;
import com.gaurav.workshop.exception.ExceptionClass;
import com.gaurav.workshop.model.Movies;
import com.gaurav.workshop.repository.MovieRepository;
import com.gaurav.workshop.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author bhishma<gaurav.basyal @ fonepay.com>
 */
@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    MovieRepository movieRepository;
    @Override
    public ResponseEntity<Object> createMovies(MovieCreateRequest movieRequest) {
        Long count=movieRepository.getMovieCountByTitle(movieRequest.getTitle());
        Movies  movies =new Movies();
        if(count>0){
            throw new ExceptionClass(String.format("Movie with that title %s exists",movieRequest.getTitle()));
        }else {
            movies.setDescription(movieRequest.getDescription());
            movies.setTitle(movieRequest.getTitle());
            movies.setPoster(movieRequest.getPoster());
            movies.setState(movieRequest.getState());
        }



        movieRepository.save(movies);
        return ResponseEntity.accepted().body("Movie created");
    }

    @Override
    public ResponseEntity<Object> editMovie(MovieModifyRequest movieRequest) {
        Movies movies=movieRepository.getMovieById(movieRequest.getId());

        if(movies==null){
            throw new ExceptionClass(String.format("Movies not found for id %d",movieRequest.getId()));
        }

        movies.setDescription(movieRequest.getDescription());
        movies.setTitle(movieRequest.getTitle());
        movies.setPoster(movieRequest.getPoster());
        movies.setState(movieRequest.getState());
        movieRepository.save(movies);

        return ResponseEntity.accepted().body("Movie edited");
    }

    @Override
    public ResponseEntity<Object> deleteMovie(Long id) {
       Movies movies=movieRepository.getMovieById(id);
       if(movies==null){
           throw new ExceptionClass("Movie not found");
       }
       movieRepository.delete(movies);
      return ResponseEntity.ok("movie deleted");
    }

    @Override
    public ResponseEntity<Object> getAllMovie() {
        List<MovieResponse> movieResponses=new ArrayList<>();
        List<Movies> movies=movieRepository.getAllMovies();
        for(Movies movie:movies){
            MovieResponse movieResponse=new MovieResponse();
            movieResponse.setId(movie.getId());
            movieResponse.setDescription(movie.getDescription());
            movieResponse.setTitle(movie.getTitle());
            movieResponse.setPoster(movie.getPoster());
            movieResponse.setState(movie.getState());

            movieResponses.add(movieResponse);

        }
        return ResponseEntity.ok(movieResponses);
    }

    @Override
    public MovieResponse getByIdMovie(Long id) {
       Movies movies=movieRepository.getMovieById(id);
       MovieResponse movieResponse=new MovieResponse();
       if(movies==null){
           throw new ExceptionClass("No movie found");
       }
       movieResponse.setTitle(movies.getTitle());
       movieResponse.setDescription(movies.getDescription());
       movieResponse.setPoster(movies.getPoster());
       movieResponse.setState(movies.getState());
       return movieResponse;
    }
}
