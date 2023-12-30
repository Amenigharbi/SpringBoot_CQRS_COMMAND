package com.enseignats.enseignement.repository;

import com.enseignats.enseignement.entity.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnseignantRepo extends JpaRepository<Enseignant,Long> {

}
