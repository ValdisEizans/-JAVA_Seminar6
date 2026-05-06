package lv.venta.service;

import java.util.ArrayList;

import lv.venta.model.Course;
import lv.venta.model.Degree;
import lv.venta.model.Professor;

public interface IFilterService {
	//visi profesori, kuri PhD
	public abstract ArrayList<Professor> filterProfessorByDegree(Degree degree) throws Exception;
	
	//prieksmets pec profesora id
	public abstract ArrayList<Course> filterCoursesByProfessorId(long id) throws Exception;
	
	//atzimes pec studenta varda un uzvarda
	
	//videja atzime, ja kursa nosaukums

}
