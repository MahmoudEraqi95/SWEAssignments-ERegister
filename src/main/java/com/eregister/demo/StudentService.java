package com.eregister.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public Optional<Student> findStudentById(Long id) {
        return studentRepository.findById(id);
    }
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }

    public List<Student> searchStudents(String searchTerm) {
        return studentRepository.findByFirstNameContainingOrLastNameContainingOrStudentNumberContaining(searchTerm, searchTerm, searchTerm);
    }


}
