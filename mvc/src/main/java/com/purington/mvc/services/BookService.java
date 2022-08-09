package com.purington.mvc.services;

import java.util.List;
import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.stereotype.Service;

import com.purington.mvc.models.Book;
import com.purington.mvc.repositories.BookRepository;

@Service 
public class BookService {
	//adding the book repository as a dependency 
	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	//Put in CRUD BELOW
	
	//Read....gets list of all books
	public List<Book> allBooks() {
		return bookRepository.findAll();
	}
	//retrieves a single 
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		}
		else return null;
	}
	
	//Create...creates a book
	public Book createBook(Book b) {
		return bookRepository.save(b);
	}
	
	//Update....updates a book
	public Book updateBook(Book book) {
		return bookRepository.save(book);
	}
	
	//Delete....delete a book
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}
	
}
