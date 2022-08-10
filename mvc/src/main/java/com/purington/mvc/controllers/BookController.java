package com.purington.mvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.purington.mvc.models.Book;
import com.purington.mvc.services.BookService;

@Controller
public class BookController {
	
	//will instantiate the service object and put it in the member variable for us
	//short hand for steps in BooksApi...do not need the keyword "final"
	@Autowired
	private BookService bookService;
	
	@GetMapping("/")
	public String index() {
		return "redirect:/books";
	}
	
	@GetMapping("/books")
	public String books(Model model) {
		
		List<Book> allBooks = bookService.allBooks();
		model.addAttribute("books", allBooks);
		
		return "index.jsp";
	}
	
	@GetMapping("/book/{Id}")
	public String index(Model model,@PathVariable("Id")Long id) {
		
		System.out.println(id); //test that the id is being passed in
		Book book = bookService.findBook(id);
		System.out.println(book.getTitle()); //test that it's actually grabbing a book
		
//		List<Book> allBooks = bookService.allBooks();
		
		model.addAttribute("book", book); //pass it on so you can use it in your jsp page
		
		return "show.jsp";
	}
	
	@GetMapping("/book/new")
	public String newBook(@ModelAttribute("book") Book book) {
		
		return "newBook.jsp";
	}
	
	@PostMapping("/createBook")
	public String createBook(
			@Valid @ModelAttribute("book") Book book,
			BindingResult result)
	{
		if(result.hasErrors()) {
			return "newBook.jsp";
		}
		else {
		bookService.createBook(book);
		return "redirect:/books";
		}
	}
	
	
	
}
