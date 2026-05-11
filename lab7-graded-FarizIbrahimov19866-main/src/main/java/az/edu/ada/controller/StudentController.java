package az.edu.ada.controller;

import az.edu.ada.model.Student;
import az.edu.ada.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping
    public Student create(@Valid @RequestBody Student student) {
        log.info("POST /students called");
        return service.create(student);
    }

    @GetMapping
    public List<Student> getAll() {
        log.info("GET /students called");
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id) {
        log.info("GET /students/{} called", id);
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Student update(@Valid @PathVariable Long id, @RequestBody Student student) {
        log.info("PUT /students/{} called", id);
        return service.update(id, student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        log.info("DELETE /students/{} called", id);
        service.delete(id);
    }
}