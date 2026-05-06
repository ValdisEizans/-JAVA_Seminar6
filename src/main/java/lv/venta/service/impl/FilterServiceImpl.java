package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Course;
import lv.venta.model.Degree;
import lv.venta.model.Grade;
import lv.venta.model.Professor;
import lv.venta.model.Student;
import lv.venta.repo.ICourseRepo;
import lv.venta.repo.IGradeRepo;
import lv.venta.repo.IProfessorRepor;
import lv.venta.repo.IStudentRepo;
import lv.venta.service.IFilterService;

@Service
public class FilterServiceImpl implements IFilterService{
	
	@Autowired
	private IProfessorRepor profRepo;
	
	@Autowired
	private ICourseRepo courseRepo;
	
	@Autowired
	private IStudentRepo studRepo;
	
	@Autowired
	private IGradeRepo gradeRepo;
	
	@Override
	public ArrayList<Professor> filterProfessorByDegree(Degree degree) throws Exception {
		if(degree == null) {
			throw new Exception("Nav noradits grads!");
		}
		ArrayList<Professor> result = profRepo.findByDegree(degree);
		
		if(result.isEmpty()) {
			throw new Exception("Nav profesoru ar gradu: " + degree);
		}
		return result;
	}

	@Override
	public ArrayList<Course> filterCoursesByProfessorId(long id) throws Exception {
		if(id <= 0) {
			throw new Exception("Profesora id nedrikst but negativs!");
		}
		if(!profRepo.existsById(id)) {
			throw new Exception("Profesors ar " + id + " neeksiste!");
		}
		
		ArrayList<Course> result = courseRepo.findByProfessorPid(id);
		if(result.isEmpty()) {
			throw new Exception("Nav kursu profesoram ar id: " + id);
		}
		return result;
	}

	@Override
	public ArrayList<Grade> filterGradesByStudentNameAndSurname(String name, String surname) throws Exception {
		if(name == null || surname == null || !name.matches("[A-Z]{1}[a-z]{2,30}") || !surname.matches("[A-Z]{1}[a-z]{2,30}")) {
			throw new Exception("Nekorekti ievades dati!");
		}
		if(!studRepo.existsByNameAndSurname(name, surname)) {
			throw new Exception("Students ar vardu " + name + " un uzvardu " + surname + " neeksiste!");
		}
		ArrayList<Grade> result = gradeRepo.findByStudentNameAndStudentSurname(name, surname);
		if(result.isEmpty()) {
			throw new Exception("Nav kursu studentam ar vardu " + name + " un uzvardu " + surname);
		}
		return result;
	}

	@Override
	public float calculateAverageGradeByCourseTitle(String title) throws Exception {
		if(title == null || !title.matches("[A-Z]{1}[a-z ]{2,30}")) {
			throw new Exception("Nekorekti ievades dati!");
		}
		if(!courseRepo.existsByTitle(title)) {
			throw new Exception("Kurss ar nosaukumu " + title + " neeksiste!");
		}
		float result = gradeRepo.calculateAverageGradeByCourseTitle(title);
		if(result == 0) {
			throw new Exception("Kursam nav atzimju, nevar aprekina videjo atzimi");
		}
		return result;
	}

	@Override
	public ArrayList<Student> filterStudentsWithFailedGrades() throws Exception {
		if(studRepo.count() == 0) {
			throw new Exception("Studentu tabula tuksa");
		}
		if(gradeRepo.count() == 0) {
			throw new Exception("Atzimju tabula tuksa");
		}
		
		ArrayList<Student> result = studRepo.findByGradesGradeLessThan(4);
		if(result.isEmpty()) {
			throw new Exception("Nav nesekmigu studentu!");
		}
		return result;
	}

}
