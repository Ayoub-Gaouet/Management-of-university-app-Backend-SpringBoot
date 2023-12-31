package org.isetn.repository;

import org.isetn.entities.Matiere;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatiereRepository extends JpaRepository<Matiere, Long> {
    List<Matiere> findByClasseCodClass(Long codClass);
}
