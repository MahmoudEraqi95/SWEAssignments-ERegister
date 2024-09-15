package com.eregister.demo;


import org.springframework.data.jpa.repository.JpaRepository;

public interface TranscriptRepository extends JpaRepository<Transcript, Long> {
    // Additional query methods can be defined here
}

