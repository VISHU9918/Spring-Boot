package com.example.rest.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.model.Book;

@RestController
@RequestMapping("/api")
public class BookRestController {
	private static List<Book>bookList= new ArrayList<Book>();
	static{
		bookList.add(new Book("C","Dennis R", 500));
		bookList.add(new Book("Java","James G", 600));
		bookList.add(new Book("Spring Boot","VM Ware", 1000));
	}
	
	@GetMapping("/books")
	public List<Book>getAllBooks(){
		return bookList;  //JSON Array =>jackson
	}
	
	@GetMapping("/books/{id}")
	public Book getBookbyId(@PathVariable("id") int bid) {
		return bookList.get(bid);
	}
	
	@PostMapping("/books")
	public Book saveBook(@RequestBody Book book) {
		// jackson
		bookList.add(book);
		return book;
	}
	
	@DeleteMapping("/books/{id}")
	public String deleteBookbyId(@PathVariable("id") int bid) {
		bookList.remove(bid);
		return "Book with " +bid+" deleted!! ";
	}
	
	@PutMapping("/books/{id}")
	public Book updateBookbyId(@PathVariable("id") int bid, @RequestBody Book ubook) {
		Book ebook=bookList.get(bid);
		ebook.setTitle(ubook.getTitle());
		
		ebook.setAuthor(ubook.getAuthor());
		ebook.setPrice(ubook.getPrice());
		return ebook;
	}

}
