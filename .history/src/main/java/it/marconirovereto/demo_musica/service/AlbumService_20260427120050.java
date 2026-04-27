package it.marconirovereto.demo_musica.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.marconirovereto.demo_musica.entity.Album;
import it.marconirovereto.demo_musica.repository.AlbumRepository;

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
      if (album.getAnnoPubblicazione() > annoCorrente || album.getAnnoPubblicazione() < 1900) {
         throw new RuntimeException("Anno di pubblicazione non valido!");
      }

      // 3. Chiamata operazione C(RUD) (Repository)
      return albumRepository.save(album);
   }

   
   @Transactional (readOnly = true)
   public List<Album> findByArtista(String artista){
      return albumRepository.findByArtista(artista);
   }

   @Transactional (readOnly = true)
   public List<Album> findByAnnoPubblicazione(int anno){
      return albumRepository.findByAnnoPubblicazione(anno);   
   }

   @Transactional (readOnly = true)
   public List<Album> findByAnnoPubblicazioneDaA(int annoda, int annoa){
      return albumRepository.findByAnnoPubblicazioneDaA(annoda, annoa);   
   }

   @Transactional (readOnly = true)
   public List<Album> findByTitolo(String titolo){
      return albumRepository.findByTitolo(titolo);   
   }


}
