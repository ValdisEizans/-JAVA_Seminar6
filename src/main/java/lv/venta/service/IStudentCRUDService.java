package lv.venta.service;

import java.util.ArrayList;

import lv.venta.model.Student;


public interface IStudentCRUDService {
	//Create
	public abstract void createNewStudent(String name, String surname) throws Exception;

	//Retrieve all
	public abstract ArrayList<Student> retrieveAll() throws Exception;
	
	//Retrieve by id
	public abstract Student retrieveStudentById(long id) throws Exception;
	
	//Update
	public abstract void updateStudentById(long id, String name, String surname) throws Exception;
	
	//Delete
	public abstract void deleteProductById(long id) throws Exception;
}
