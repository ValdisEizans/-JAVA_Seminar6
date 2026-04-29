package lv.venta.repo;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Student;

public interface IStudentRepo extends CrudRepository<Student, Long>{
	Student findByNameAndSurname(String name, String surname);

}
