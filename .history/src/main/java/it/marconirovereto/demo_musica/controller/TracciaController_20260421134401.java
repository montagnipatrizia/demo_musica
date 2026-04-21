package it.marconirovereto.demo_musica.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.marconirovereto.demo_musica.entity.Traccia;
import com.example.demo_01.repository.TracciaRepository;


@RestController
@RequestMapping("/api/tracce")
public class TracciaController {
    @Autowired
    TracciaRepository tracciaRepository;

    @GetMapping("/all")
    public List<Traccia> getAllTracce() {
        return tracciaRepository.findAll();
    }
    
    @GetMapping("/id/{id}")
    public Optional<Traccia> getTracciaById(@PathVariable int id) {
        Optional<Traccia> x = tracciaRepository.findById(id);
        if (x.isPresent())
            return x;
        else
            return null;
    }
}

