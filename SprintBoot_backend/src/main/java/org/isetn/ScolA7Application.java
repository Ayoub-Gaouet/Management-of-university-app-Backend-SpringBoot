package org.isetn;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.isetn.entities.*;
import org.isetn.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class ScolA7Application implements CommandLineRunner {
	@Autowired
	private FormationRepository formationRepository;

	@Autowired
	private ClasseRepository classeRepository;

	@Autowired
	private EtudiantRepository etudiantRepository;

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private DepartementRepository depRepository;
	@Autowired
	private MatiereRepository matiereRepository;
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
@Autowired
	private AbsenceRepository absenceRepository;
	public static void main(String[] args) {
		SpringApplication.run(ScolA7Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Departement ti= depRepository.save(new Departement(null,"TI",null));
		Departement ge= depRepository.save(new Departement(null,"GE",null));
		Departement gc= depRepository.save(new Departement(null,"GC",null));
		Formation f1 = formationRepository.save(new Formation(null,"Oracle",100,null));
		Formation f2 = formationRepository.save(new Formation(null,"J2EE",10,null));
		Formation f3 = formationRepository.save(new Formation(null,"Angular",120,null));
		Classe c1 = classeRepository.save(new Classe(null,"DSI31",27,null,null,ti));
		Classe c2 = classeRepository.save(new Classe(null,"DSI32",25,null,null,ti));
		Classe c3 = classeRepository.save(new Classe(null,"DSI33",20,null,null,ti));
		Classe c4 = classeRepository.save(new Classe(null,"GC11",20,null,null,gc));
		User u1 = userRepository.save(new User(null,"admin@gmail.com","admin"));
		SimpleDateFormat fdate = new SimpleDateFormat("dd-MM-yyyy");

		Etudiant e1 = etudiantRepository.save(new Etudiant(null, "Ali", "Ben Ali", fdate.parse("10-03-2021"),f1,c1));
		Etudiant e2 = etudiantRepository.save(new Etudiant(null, "Ahmed", "Ben Ahmed", fdate.parse("10-03-2021"),f1,c1));
		Etudiant e3 = etudiantRepository.save(new Etudiant(null, "Mohamed", "Ben Mohamed", fdate.parse("10-03-2021"),f1,c1));
		Etudiant e4 = etudiantRepository.save(new Etudiant(null, "Amin", "Ben Mahmoud", fdate.parse("10-03-2021"),f2,c1));
		Etudiant e5 = etudiantRepository.save(new Etudiant(null, "Samia", "Ben Ahmed", fdate.parse("10-03-2021"),f3,c1));
		Etudiant e6 = etudiantRepository.save(new Etudiant(null, "Foulen", "Ben Foulen1", fdate.parse("10-03-2021"),f3,c2));
		Etudiant e7 = etudiantRepository.save(new Etudiant(null, "Foulen", "Ben Foulen2", new Date(),f3,c3));

		Matiere m1 = new Matiere(null, "Mathematics", 4, 30, c1);
		Matiere m2 = new Matiere(null, "Physics", 3, 20, c1);
		Matiere m3 = new Matiere(null, "Chemistry", 2, 15, c2);
		Matiere m4 = new Matiere(null, "Biology", 3, 25, c2);
		matiereRepository.save(m1);
		matiereRepository.save(m2);
		matiereRepository.save(m3);
		matiereRepository.save(m4);
		Absence a1 = absenceRepository.save(new Absence(null, m1, e1, fdate.parse("10-03-2021"), 1));
		Absence a2 = absenceRepository.save(new Absence(null, m1, e2, fdate.parse("10-03-2021"), 1));
		Absence a3 = absenceRepository.save(new Absence(null, m1, e3, fdate.parse("10-03-2021"), 1));
		Absence a4 = absenceRepository.save(new Absence(null, m1, e4, fdate.parse("10-03-2021"), 1));
		Absence a5 = absenceRepository.save(new Absence(null, m1, e5, fdate.parse("10-03-2021"), 1));
	}
}