package se.lexicon.simon.jpafirstlookcodeshow.data_access;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;

import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.simon.jpafirstlookcodeshow.entity.Student;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureTestDatabase
@AutoConfigureTestEntityManager
@Transactional

class StudentDaoJpaImplTest {


    @Autowired
    StudentDao testDao;
    @Autowired
    TestEntityManager entityManager;

    Student testObject;


    @BeforeEach
    void setUp() {

       testObject = entityManager.persistAndFlush(new Student("Test", "Testsson"));

        assertNotNull(testObject);

    }

    @AfterEach
    void tearDown() {
        entityManager.flush();
        entityManager.clear();
    }

    @Test
    void testSave() {
        //Arrange - Preparing Student to be Persisted.
        Student student = new Student("Simon", "Elbrink");

        //Act - Saving Student to database.
        testDao.save(student);

        //Assert - Checking if "student" is the same Student found in database.
        assertEquals(student, entityManager.find(Student.class, student.getId()));
        /*
         Notice that we are not storing the value after saving, we still get the ID stored in student.
         - Because we are in transaction.
         */
    }

    @Test
    void findById() {
        //Arrange
        Student expected = testObject;

        //Act
        Student actual = testDao.findById(testObject.getId());

        //Assert
        assertNotNull(expected);
        assertEquals(expected, actual);

    }



    @Test
    void findAll() {
        // Arrange
        int expectedSize = 1;


        // Act
        List<Student> all = testDao.findAll();

        //Assert
        assertNotNull(all);
        assertEquals(testObject, all.get(0));
        assertEquals(expectedSize, all.size());
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}