package com.gaurav.workshop.dto;

import lombok.Data;

/**
 * @author bhishma<gaurav.basyal @ fonepay.com>
 */
@Data
public class MovieResponse {
    private Long id;
    private String title;
    private String description;
    private String state;
    private String poster;
}
