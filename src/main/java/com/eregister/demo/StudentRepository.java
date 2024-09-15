package com.eregister.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByFirstNameContainingOrLastNameContainingOrStudentNumberContaining(String firstName, String lastName, String studentNumber);

}

