package it.marconirovereto.demo_musica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.marconirovereto.demo_musica.ntity.Traccia;

@Repository
public interface TracciaRepository extends JpaRepository<Traccia, Integer>{
    
}

