package it.marconirovereto.demo_musica.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import it.marconirovereto.demo_musica.entity.Album;
import it.marconirovereto.demo_musica.repository.AlbumRepository;
import it.marconirovereto.demo_musica.service.AlbumService;

@RestController
@RequestMapping("/api/albums")
@Tag(name = "Albums", description = "Gestione raccolta album musicali")
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    
    @GetMapping("/all")
	@Operation(
		summary = "Ritorna tutti gli album",
		description = "Lista di tutti gli albums presenti nel DB"
	)
	public List<Album> getAllAlbum() {
		return albumRepository.findAll();
	}
	
	@GetMapping("/id/{id}")
	@Operation(
		summary = "Album by id",
		description = "Restituisce l'album dato il suo id (se presente)"
	)
	public Optional<Album> getAlbumById(@PathVariable int id) {
		Optional<Album> x = albumRepository.findById(id);
		if (x.isPresent())
            return x;
		else 
			return null;
	}

	@GetMapping("/artista/{artista}")
	public List<Album> getAlbumByArtista(@PathVariable String artista) {
		return albumRepository.findByArtista(artista);
	}
	
	@GetMapping("/anno/{anno}")
	public List<Album> getAlbumByAnnoPubblicazione(@PathVariable int anno) {
		return albumRepository.findByAnnoPubblicazione(anno);
	}
	
	@GetMapping("/intervallo/{annoda}/{annoa}")
	public List<Album> getAlbumByAnnoPubblicazioneDaA(@PathVariable int annoda, @PathVariable int annoa) {
		return albumRepository.findByAnnoPubblicazioneDaA(annoda, annoa);
	}

	@GetMapping("/titolo/{titolo}")
	public List<Album> getAlbumByTitolo(@PathVariable String titolo) {
		return albumRepository.findByTitolo(titolo);
	}
	
	@PostMapping("/save")
	public String postAlbumSave(@RequestBody Album album) {
		albumRepository.save(album);
		return "Inserimento avvenuto con successo";
	}
	
	
}
