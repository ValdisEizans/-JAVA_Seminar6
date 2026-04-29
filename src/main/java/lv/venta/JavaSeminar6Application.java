package lv.venta;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lv.venta.model.Course;
import lv.venta.model.Degree;
import lv.venta.model.Grade;
import lv.venta.model.Professor;
import lv.venta.model.Student;
import lv.venta.repo.ICourseRepo;
import lv.venta.repo.IGradeRepo;
import lv.venta.repo.IProfessorRepor;
import lv.venta.repo.IStudentRepo;

@SpringBootApplication
public class JavaSeminar6Application {

	public static void main(String[] args) {
		SpringApplication.run(JavaSeminar6Application.class, args);
	}

	@Bean//izpilda automatiski funkciju startejot sistemu
	public CommandLineRunner testRepo(IStudentRepo studRepo, IProfessorRepor profRepo, ICourseRepo courseRepo, IGradeRepo gradeRepo) {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				Student stud1 = new Student("Valdis","Eizans");
				Student stud2 = new Student("Guntis","Eglitis");
				Student stud3 = new Student("Kristaps","Abols");
				studRepo.saveAll(Arrays.asList(stud1,stud2,stud3));
				
				Professor prof1 = new Professor("Agris","Ziemelis",Degree.barchelor);
				Professor prof2= new Professor("Andris","Gobzems",Degree.phd);
				profRepo.saveAll(Arrays.asList(prof1,prof2));
				
				Course course1 = new Course("Matematika",3,prof1);
				Course course2 = new Course("Ekonomika",6,prof2);
				courseRepo.saveAll(Arrays.asList(course1,course2));
				
				Grade grade1 = new Grade(4,stud1,course1);
				Grade grade2 = new Grade(5,stud1,course2);
				Grade grade3 = new Grade(8,stud2,course1);
				Grade grade4 = new Grade(7,stud2,course2);
				gradeRepo.saveAll(Arrays.asList(grade1,grade2,grade3,grade4));

			}
		};
	}
	
	
}
