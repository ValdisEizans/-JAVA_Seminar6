package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Grade;
import lv.venta.model.Student;
import lv.venta.repo.IGradeRepo;
import lv.venta.repo.IStudentRepo;
import lv.venta.service.IStudentCRUDService;

@Service
public class StudentCRUDServiceImpl implements IStudentCRUDService{

	@Autowired
	private IStudentRepo studRepo;
	
	@Autowired
	private IGradeRepo gradeRepo;
	
	@Override
	public ArrayList<Student> retrieveAll() throws Exception {
		if(studRepo.count() == 0) {
			throw new Exception("Studentu tabula DB ir tuksa!");
		}
		ArrayList<Student> allStudentsFromDb = (ArrayList<Student>) studRepo.findAll();
		return allStudentsFromDb;
	}

	@Override
	public Student retrieveById(long id) throws Exception {
		//parbauda vai nav negativs
		if(id <= 0) {
			throw new Exception("Studenta Id nedrikst but negativs vai nulle!");
		}
		//parbauda vai ir tads id (existsById)
		if(!studRepo.existsById(id)) {
			throw new Exception("Students ar sadu Id neeksiste!");
		}
		//ja ir, tad no DB iegust produktu
		Student studentFromDb = studRepo.findById(id).get();
		
		return studentFromDb;
	}

	@Override
	public void deleteById(long id) throws Exception {
		Student studentForRemoving = retrieveById(id);
		//Atkabinam ka FK no citam tabulam
		
		ArrayList<Grade> gradesForStudent = gradeRepo.findByStudentSid(id);
		
		for(Grade tempG :gradesForStudent) {
			tempG.setStudent(null);
			gradeRepo.save(tempG);
		}
		studRepo.delete(studentForRemoving);				
	}

	@Override
	public void create(String name, String surname) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateById(long id, String name, String surname) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
