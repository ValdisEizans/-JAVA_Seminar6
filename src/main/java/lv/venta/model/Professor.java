package lv.venta.model;

import java.util.ArrayList;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name="ProfessorTable")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Professor extends Person{
	@Setter(value = AccessLevel.NONE)
	@Column(name= "Pid")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long pid;
	
	@Column(name= "Degree")
	@Enumerated(EnumType.STRING)
	@NotNull
	private Degree degree;
	
	
	//sasaiste ar kursu
	@ManyToMany(mappedBy = "professors")
	@ToString.Exclude
	public Collection<Course> courses = new ArrayList<Course>();
	
	public Professor(String name, String surname, Degree degree) {
		super(name, surname);
		setDegree(degree);
	}
	
	public void addCourse(Course inputcourse) throws Exception {
		if(inputcourse == null) {
			throw new Exception("Nekorekti ievades dati!");
		}
		if(courses.contains(inputcourse)) {
			throw new Exception(inputcourse.getTitle() + " jau eksiste saraksta!");
		}
		courses.add(inputcourse);
	}
	
	//Lidzigi veido remove funkciju
	public void removeCourse(Course inputcourse) throws Exception {
		if(inputcourse == null) {
			throw new Exception("Nekorekti ievades dati!");
		}
		if(!courses.contains(inputcourse)) {
			throw new Exception(inputcourse.getTitle() + " neeksiste saraksta!");
		}
		courses.remove(inputcourse);
	}
	
}
