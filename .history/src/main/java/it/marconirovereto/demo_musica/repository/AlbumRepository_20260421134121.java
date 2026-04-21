package it.marconirovereto.demo_musica.repository;

// corrisponde alla classe AlbumDao usata con JPA... --> gestisce le query

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo_01.entity.Album;


@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer> {
    /* 
        Vuoto! Spring fa tutto il lavoro sporco:
        abbiamo già i metodi di inserimento/modifica, lettura, cancellazione e molti altri...
    */
    /* 
        Aggiungiamo solo eventuali metodi specifici, e possiamo evitare di scriverli manualmente affidandoci a Spring per l'implementazione...
        Questi metodi prendono il nome di query methods!
        Spring analizza il nome e scrive l'implementazione al posto nostro...
        Ecco alcuni esempi!
    */
    // Query method: cerco tutti gli album di un certo artista
    public List<Album> findByArtista(String artista);

    // Query method: cerco tutti gli album pubblicati in un certo anno
    public List<Album> findByAnnoPubblicazione(int anno);

    /*
        Se,invece, vogliamo implementare manualmente la query (in JPQL o in SQL nativo), 
        dobbiamo utilizzare annotare il metodo con @Query...
        Ecco alcuni esempi!
    */
    // JPQL: cerco gli album pubblicati in un certo intervallo temporale
    @Query ("SELECT a FROM Album a WHERE a.annoPubblicazione >= :annoda AND annoPubblicazione <= :annoa")
    public List<Album> findByAnnoPubblicazioneDaA(@Param("annoda") int annoda, @Param("annoa") int annoa);
    // SQL nativo/puro: cerco gli album con un titolo specifico
    @Query (value="SELECT * FROM albums WHERE titolo LIKE :titolo", nativeQuery = true)
    public List<Album> findByTitolo(@Param("titolo") String titolo);
   
   
}

