package lv.venta.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Degree;
import lv.venta.model.Professor;

public interface IProfessorRepor extends CrudRepository<Professor, Long>{

	ArrayList<Professor> findByDegree(Degree degree);

}
