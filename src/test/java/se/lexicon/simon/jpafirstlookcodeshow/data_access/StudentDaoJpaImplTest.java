package se.lexicon.simon.jpafirstlookcodeshow.data_access;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.simon.jpafirstlookcodeshow.entity.Student;

import static org.junit.jupiter.api.Assertions.*;


class StudentDaoJpaImplTest {


    @Autowired
    StudentDao testDao;



    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void save() {

        Student student = new Student("Test", "Testsson");

        testDao.save(student);



    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}