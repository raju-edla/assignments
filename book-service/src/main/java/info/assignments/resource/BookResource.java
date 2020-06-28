package info.assignments.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import info.assignments.entity.Book;
import info.assignments.logger.AppLogger;
import info.assignments.logger.AppLoggerFactory;
import info.assignments.service.BookService;

@RestController
@RequestMapping("/api/book")
public class BookResource {

	@Autowired
	private BookService bookService;

	private AppLogger logger = AppLoggerFactory.getLogger(BookResource.class);

	@GetMapping
	public ResponseEntity<List<Book>> getAllBookDetails() {
		logger.debug("REST request to get all Books");
		return ResponseEntity.ok().body(bookService.getAllBookDetails());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Book> getBookDetailsById(@PathVariable Long id) {
		logger.debug("REST request to get Book by Id : " + id);
		return bookService.getBookById(id).map(response -> ResponseEntity.ok().body(response))
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	@PostMapping
	public ResponseEntity<Book> saveBookDetails(@RequestBody Book book) throws Exception {
		logger.debug("REST request to save Book : ", book);
		if (book.getBookId() != null) {
			throw new Exception("A new book cannot already have an ID");
		}
		Book result = bookService.saveBook(book);
		return ResponseEntity.created(new URI("/api/registration/" + result.getBookId())).body(result);

	}

	@PutMapping
	public ResponseEntity<Book> updateBookDetails(@RequestBody Book book) throws Exception {
		logger.debug("REST request to update Book :", book);
		if (book.getBookId() == null) {
			throw new Exception("Invlaid book id ");
		}
		Book result = bookService.updateBook(book);
		return ResponseEntity.ok().body(result);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBookDetails(@PathVariable Long id) {
		logger.debug("REST request to delete Book :", id);
		bookService.deleteBookDetails(id);
		return ResponseEntity.noContent().build();
	}

}
