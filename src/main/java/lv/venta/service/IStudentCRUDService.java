package lv.venta.service;

import lv.venta.model.Student;

public interface IStudentCRUDService extends ICRUDServiceBase<Student>{
	//Create
	public abstract void create(String name, String surname) throws Exception;
	
	//Update by id
	public abstract void updateById(long id, String name, String surname) throws Exception;
}
