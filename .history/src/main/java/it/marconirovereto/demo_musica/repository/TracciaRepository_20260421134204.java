package it.marconirovereto.demo_musica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo_01.entity.Traccia;

@Repository
public interface TracciaRepository extends JpaRepository<Traccia, Integer>{
    
}

