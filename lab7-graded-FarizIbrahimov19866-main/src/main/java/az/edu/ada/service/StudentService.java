package az.edu.ada.service;

import az.edu.ada.model.Student;

import java.util.List;

public interface StudentService {

    Student create(Student student);

    List<Student> getAll();

    Student getById(Long id);

    Student update(Long id, Student student);

    void delete(Long id);
}