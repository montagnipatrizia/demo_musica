package it.marconirovereto.demo_musica.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.marconirovereto.demo_musica.entity.Album;
import it.marconirovereto.demo_musica.repository.AlbumRepository;
import jakarta.transaction.Transactional;

/* Dichiarazione dei services per Album:
   Esempio:
   -) verificare che l'anno di pubblicazione sia valido (non nel futuro e non in un passato troppo remoto) 
   -) assicurarsi che il titolo sia in maiuscolo
   Nota: dal punto di vista della scalabilità si può optare per un'Interface,
         l'implementazione della quale si potrebbe collocare in un subpackage "impl".
         In questo caso l'annotazione @Service dovrà essere inserita nell'implementazione...
*/

@Service
public class AlbumService {
    @Autowired
    private AlbumRepository albumRepository;

    @Transactional // Garantisce che l'operazione sia atomica
    public Album salvaNuovoAlbum(Album album) {
        // 1. Logica di business: Trasformazione
        album.setTitolo(album.getTitolo().toUpperCase());

        // 2. Logica di business: Validazione
        int annoCorrente = LocalDate.now().getYear();
        if (album.getAnnoPubblicazione() > annoCorrente || album) {
            throw new RuntimeException("Anno di pubblicazione non valido!");
        }

        // 3. Chiamata al braccio operativo (Repository)
        return albumRepository.save(album);
    }
}
