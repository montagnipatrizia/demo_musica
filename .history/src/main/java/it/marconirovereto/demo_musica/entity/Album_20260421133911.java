package it.marconirovereto.demo_musica.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table (name="albums")
@Getter 
@Setter 
@NoArgsConstructor 
@AllArgsConstructor
public class Album {
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    int id;
    String titolo;
    String artista;
    @Column (name="anno_pubblicazione")
    int annoPubblicazione;

}
