package se.lexicon.simon.jpafirstlookcodeshow.data_access;

import se.lexicon.simon.jpafirstlookcodeshow.entity.Student;

import java.util.List;

public interface StudentDao {

    //CRUD

    Student save(Student student);

    Student findById(int id);

    List<Student> findAll();

    Student update(Student student);

    void delete(int id);


}
