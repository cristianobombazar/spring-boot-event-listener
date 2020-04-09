package com.example.eventslistners.repository;

import com.example.eventslistners.model.Author;
import com.example.eventslistners.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    boolean existsByTitleAndAuthor(String title, Author author);
}
