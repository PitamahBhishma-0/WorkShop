package com.gaurav.workshop.service;

import com.gaurav.workshop.dto.*;
import com.gaurav.workshop.dto.MovieResponse;
import org.springframework.http.ResponseEntity;

/**
 * @author bhishma<gaurav.basyal @ fonepay.com>
 */
public interface MovieService {

    public ResponseEntity<Object>  createMovies(MovieCreateRequest movieRequest);
    public ResponseEntity<Object>  editMovie(MovieModifyRequest movieRequest);
    public ResponseEntity<Object>  deleteMovie(Long id);
    public ResponseEntity<Object>  getAllMovie();
    public MovieResponse  getByIdMovie(Long id);
}
