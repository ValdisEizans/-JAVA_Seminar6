package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name="SubjectTable")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Subject {
	@Setter(value = AccessLevel.NONE)
	@Column(name= "Sid")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long sid;
	
	@Column(name= "Title")
	@NotNull
	@NotEmpty
	@Pattern(regexp = "[A-Z]{1}[a-z]{2,30}")
	private String title;
	
	@Column(name= "CP")
	private int cp;
	
	public Subject(String title, String surname) {
		setTitle(title);
	}
}
