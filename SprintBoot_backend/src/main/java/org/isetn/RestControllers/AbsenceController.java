package org.isetn.RestControllers;

import org.isetn.entities.Absence;
import org.isetn.repository.AbsenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("absences")
public class AbsenceController {

    @Autowired
    private AbsenceRepository absenceRepository;

    @PostMapping("/add")
    public Absence add(@RequestBody Absence absence) {
        return absenceRepository.save(absence);
    }

    @GetMapping("/all")
    public List<Absence> getAll() {
        return absenceRepository.findAll();
    }
    @GetMapping("/getByStudent/{studentId}")
    public List<Absence> getByStudentId(@PathVariable Long studentId) {
        return absenceRepository.findByEtudiant_Id(studentId);
    }
    @GetMapping("/get/{id}")
    public Optional<Absence> getById(@PathVariable Long id) {
        return absenceRepository.findById(id);
    }
    @DeleteMapping("/delete")
    public void delete(@Param("id") Long id) {
        Absence absence = absenceRepository.findById(id).orElse(null);
        if (absence != null) {
            absenceRepository.delete(absence);
        }
    }

    @PutMapping("/update")
    public Absence update(@RequestBody Absence absence) {
        return absenceRepository.save(absence);
    }
}