package com.example.eventslistners.repository;

import com.example.eventslistners.model.PublicationBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicationBookRepository extends JpaRepository<PublicationBook, Long> {
}
