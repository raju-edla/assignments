package info.assignments.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.assignments.entity.Book;
import info.assignments.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepository bookRepository;

	@Override
	public List<Book> getAllBookDetails() {
		return bookRepository.findAll();
	}

	@Override
	public Book saveBook(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public Book updateBook(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public Optional<Book> getBookById(Long bookId) {
		return bookRepository.findById(bookId);
	}

	@Override
	public void deleteBookDetails(Long bookId) {
		bookRepository.deleteById(bookId);
	}

}
