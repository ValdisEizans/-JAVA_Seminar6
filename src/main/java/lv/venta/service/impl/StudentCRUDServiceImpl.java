package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import lv.venta.model.Student;
import lv.venta.repo.IStudentRepo;
import lv.venta.service.IStudentCRUDService;

public class StudentCRUDServiceImpl implements IStudentCRUDService {

	@Autowired
	private IStudentRepo studRepo;
	
	@Override
	public void createNewStudent(String name, String surname) throws Exception {
		if(name == null || !name.matches("[A-Z]{1}[a-z]{2,30}") || surname == null || !surname.matches("[A-Z]{1}[a-z]{2,30}")) {
			throw new Exception("Nekorekti ievades dati!");
		}
		
		
	}

	@Override
	public ArrayList<Student> retrieveAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student retrieveStudentById(long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateStudentById(long id, String name, String surname) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProductById(long id) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
