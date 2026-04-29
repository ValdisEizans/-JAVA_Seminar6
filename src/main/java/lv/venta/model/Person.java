package lv.venta.model;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//1. variants - no klases neveidojas tabula DB
@MappedSuperclass // Nelieto @table un @entity, tikai column
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Person {

	@NotNull
	@NotEmpty
	@Pattern(regexp = "[A-Z]{1}[a-z]{2,30}")
	@Column(name= "Name")
	private String name;
	
	@NotNull
	@NotEmpty
	@Pattern(regexp = "[A-Z]{1}[a-z]{2,30}")
	@Column(name= "Surname")
	private String surname;
	
	public Person(String name, String surname) {
		setName(name);
		setSurname(surname);
	}

}
