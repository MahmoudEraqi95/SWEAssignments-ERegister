package com.eregister.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassroomRepository extends JpaRepository<Classroom, Long> {
    // Additional query methods can be defined here
}

