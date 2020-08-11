package se.lexicon.simon.jpafirstlookcodeshow.data_access;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.simon.jpafirstlookcodeshow.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Transactional
@Repository
public class StudentDaoJpaImpl implements StudentDao{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Student save(Student student) {

        entityManager.persist(student);

        return student;
    }

    @Override
    public Student findById(int id) {
        Student foundStudent = entityManager.find(Student.class, id);
        return foundStudent;
    }


    @Override
    public List<Student> findAll() {
        Query query = entityManager.createQuery("SELECT s FROM Student s");
        List<Student> allStudents = query.getResultList();

        return allStudents;
    }

    @Override
    public Student update(Student student) {

        Student updated = entityManager.merge(student);

        return updated;
    }


    @Override
    public void delete(int id) {

        Student student = findById(id);

        if (student != null){
            entityManager.remove(student);
        }
    }
}
