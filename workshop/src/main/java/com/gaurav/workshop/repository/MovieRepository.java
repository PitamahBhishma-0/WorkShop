package com.gaurav.workshop.repository;

import com.gaurav.workshop.model.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author bhishma<gaurav.basyal @ fonepay.com>
 */
public interface MovieRepository extends JpaRepository<Movies,Long> {
    @Query(value = "SELECT count(m.title) FROM movies m WHERE m.title =:title",nativeQuery = true)
    Long getMovieCountByTitle(String title);
    @Query(value = "SELECT m.* FROM movies m where m.id=:id",nativeQuery = true)
    Movies getMovieById(Long id);
    @Query(value = "SELECT * FROM movies",nativeQuery = true)
    List<Movies> getAllMovies();
}
