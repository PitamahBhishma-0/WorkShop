package com.gaurav.workshop.controller;

import com.gaurav.workshop.dto.MovieCreateRequest;
import com.gaurav.workshop.dto.MovieModifyRequest;
import com.gaurav.workshop.dto.MovieResponse;
import com.gaurav.workshop.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author bhishma<gaurav.basyal @ fonepay.com>
 */
@RestController
@RequestMapping("movies")
@CrossOrigin(origins = "*")
public class MovieController {
    @Autowired
    MovieService movieService;
    @PostMapping("create")
    public ResponseEntity<Object> createMovie(@RequestBody MovieCreateRequest movieCreateRequest){
        return movieService.createMovies(movieCreateRequest);
    }

    @PostMapping("edit")
    public ResponseEntity<Object> editMovie(@RequestBody MovieModifyRequest movieCreateRequest){
        return movieService.editMovie(movieCreateRequest);
    }

    @DeleteMapping("delete"+"/"+"{id}")
    public ResponseEntity<Object> deleteMovie(@PathVariable("id") Long id){
        return movieService.deleteMovie(id);
    }

    @GetMapping("getAllMovie")
    public ResponseEntity<Object> getAllMovie(){
        return movieService.getAllMovie();
    }

    @PostMapping("movies"+"/"+"{id}")
    public MovieResponse getById(@PathVariable("id") Long id){
        return movieService.getByIdMovie(id);
    }



}
