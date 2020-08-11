package se.lexicon.simon.jpafirstlookcodeshow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import se.lexicon.simon.jpafirstlookcodeshow.data_access.StudentDao;
import se.lexicon.simon.jpafirstlookcodeshow.entity.Student;

@SpringBootApplication
public class JpaFirstlookCodeshowApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaFirstlookCodeshowApplication.class, args);
	}

}
