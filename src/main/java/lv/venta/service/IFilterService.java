package lv.venta.service;

import java.util.ArrayList;

import lv.venta.model.Course;
import lv.venta.model.Degree;
import lv.venta.model.Grade;
import lv.venta.model.Professor;
import lv.venta.model.Student;

public interface IFilterService {
	//visi profesori, kuriem ir konkretais grads
	public abstract ArrayList<Professor> filterProfessorsByDegree(Degree degree) throws Exception;
	
	//kursi,kuri atlasiti pec profesora id
	public abstract ArrayList<Course> filterCoursesByProfessorId(long id) throws Exception;
	
	//atzimes pec studenta varda un uzvarda
	public abstract ArrayList<Grade> filterGradesByStudentNameAndSurname(String name, String surname) throws Exception;

	//videja atzime, ja kursa nosaukums
	public abstract float calculateAverageGradeByCourseTitle(String title) throws Exception;

	//iegut visus studentus, kuriem ir kada nesekmiga atzime
	public abstract ArrayList<Student> filterStudentsWithFailedGrades() throws Exception;
}
