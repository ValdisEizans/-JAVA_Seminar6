package lv.venta.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Student;

public interface IStudentRepo extends CrudRepository<Student, Long>{
	Student findByNameAndSurname(String name, String surname);

	boolean existsByNameAndSurname(String name, String surname);

	ArrayList<Student> findByGradesGradeLessThan(int i);

}
