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

import it.marconirovereto.demo_musica.entity.Album;
import it.marconirovereto.demo_musica.repository.AlbumRepository;



@RestController
@RequestMapping("/api/albums")
public class AlbumController {
    @Autowired
    private AlbumRepository albumRepository;

    
    @GetMapping("/all")
	public List<Album> getAllAlbum() {
		return albumRepository.findAll();
	}
	
	@GetMapping("/id/{id}")
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
	
	@PostMapping("save")
	public String postAlbumSave(@RequestBody Album album) {
		albumRepository.save(album);
		return "Inserimento avvenuto con successo";
	}
	
	
}
