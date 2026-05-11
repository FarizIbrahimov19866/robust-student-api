package az.edu.ada.service.impl;

import az.edu.ada.exception.StudentNotFoundException;
import az.edu.ada.model.Student;
import az.edu.ada.repository.StudentRepository;
import az.edu.ada.service.StudentService;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Student create(Student student) {
        log.info("Creating student with id {}", student.getFullName());
        return repository.save(student);
    }

    @Override
    public List<Student> getAll() {
        log.info("Retrieving all students");
        return repository.findAll();
    }

    @Override
    public Student getById(Long id) {
        log.info("Retrieving student with id {}", id);
        return repository.findById(id).orElseThrow(() -> {
            log.error("Student with id {} not found", id);
            return new StudentNotFoundException("Student with id " + id + " not found");
        });
    }

    @Override
    public Student update(Long id, Student student) {
        log.info("Updating student with id {}", id);
        if (!repository.existsById(id)) {
            log.error("Student with id {} not found for update", id);
            throw new StudentNotFoundException("Student not found by id " + id);
        }

        student.setId(id);
        return repository.save(student);
    }

    @Override
    public void delete(Long id) {
        log.info("Deleting student with id {}", id);
        if (!repository.existsById(id)) {
            log.error("Student with id {} not found fro deleting", id);
            throw new StudentNotFoundException("Student not found by id " + id);
        }
        repository.deleteById(id);
    }
}