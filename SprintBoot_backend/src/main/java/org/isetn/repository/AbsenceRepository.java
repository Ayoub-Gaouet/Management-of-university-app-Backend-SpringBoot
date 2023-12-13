package org.isetn.repository;

import org.isetn.entities.Absence;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AbsenceRepository extends JpaRepository<Absence, Long> {
        List<Absence> findByEtudiant_Id(Long studentId);
}