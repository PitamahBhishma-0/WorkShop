package com.gaurav.workshop.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author bhishma<gaurav.basyal @ fonepay.com>
 */
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Movies {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", nullable = false)
    private Long id;
    @Column(name = "description")
    private String description;
    @Column(name = "title")
    private String title;
    @Column(name="poster")
    private String poster;
    @Column(name = "state")
    private String state;
}
