package se.lexicon.simon.jpafirstlookcodeshow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.lexicon.simon.jpafirstlookcodeshow.data_access.StudentDao;
import se.lexicon.simon.jpafirstlookcodeshow.entity.Student;

@Component
public class MyCommandLineRunner implements CommandLineRunner {

    @Autowired
    StudentDao dao;

    @Override
    public void run(String... args) throws Exception {

        Student student = new Student("Simon", "Elbrink");
        Student student1 = new Student("Erik", "Svensson");

        dao.save(student);
        dao.save(student1);

        System.out.println(dao.findAll());


    }
}
