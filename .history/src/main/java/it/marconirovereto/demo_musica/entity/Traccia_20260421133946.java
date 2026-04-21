package it.marconirovereto.demo_musica.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table (name ="tracce")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Traccia {
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    int id;
    String titolo;
    int durata_min;
    int durata_sec;
    String album_lato;
    @ManyToOne
    Album album;
}
