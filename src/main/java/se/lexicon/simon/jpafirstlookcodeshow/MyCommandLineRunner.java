package se.lexicon.simon.jpafirstlookcodeshow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import se.lexicon.simon.jpafirstlookcodeshow.data_access.StudentDao;
import se.lexicon.simon.jpafirstlookcodeshow.entity.Student;

@Profile("!test")
@Component
public class MyCommandLineRunner implements CommandLineRunner {

    private StudentDao dao;

    @Autowired
    public MyCommandLineRunner(StudentDao dao) {
        this.dao = dao;
    }

    @Override
    public void run(String... args) {

        Student student = new Student("Simon", "Elbrink");
        Student student1 = new Student("Erik", "Svensson");

        dao.save(student);
        dao.save(student1);

        System.out.println(dao.findAll());


    }
}
