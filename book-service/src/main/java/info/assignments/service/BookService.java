package info.assignments.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import info.assignments.entity.Book;

@Service
public interface BookService {
	
	public List<Book> getAllBookDetails();
	
	public Book saveBook(Book book);
	
	public Book updateBook(Book book);

	public Optional<Book> getBookById(Long bookId);

	public void deleteBookDetails(Long bookId);

}
