package info.assignments.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import info.assignments.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
