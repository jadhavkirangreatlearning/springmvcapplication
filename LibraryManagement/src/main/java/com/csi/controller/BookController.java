package com.csi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.csi.model.Book;
import com.csi.service.BookService;

@Controller
@RequestMapping("/books")
public class BookController {

	@Autowired
	BookService bookServiceImpl;

	@RequestMapping("/list")
	public String listBook(Model model) {

		List<Book> books = bookServiceImpl.getAllBookData();

		model.addAttribute("Books", books);

		return "showBookList";

	}

	@RequestMapping("/showFormForAdd")
	public String showFormFoAdd(Model model) {
		Book book = new Book();
		model.addAttribute("Book", book);
		return "addBook";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("bookId") int bookId, Model model) {
		Book book = bookServiceImpl.findBookById(bookId);

		model.addAttribute("Book", book);

		return "addBook";
	}

	@RequestMapping("/save")
	public String saveBook(@RequestParam("bookId") int bookId, @RequestParam("bookName") String bookName,
			@RequestParam("bookAuthor") String bookAuthor, @RequestParam("bookCategory") String bookCategory) {

		Book book;
		if (bookId != 0) {
			book = bookServiceImpl.findBookById(bookId);
			book.setBookName(bookName);
			book.setBookAuthor(bookAuthor);
			book.setBookCategory(bookCategory);
		} else {
			book = new Book(bookName, bookAuthor, bookCategory);

			bookServiceImpl.saveBookData(book);
		}

		return "redirect:/books/list";
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("bookId") int bookId) {

		bookServiceImpl.deleteBookById(bookId);
		return "redirect:/books/list";
	}
	
	@RequestMapping("search")
	public String search(@RequestParam("bookName") String bookName,
			@RequestParam("bookAuthor") String bookAuthor, Model model) {
		
		if(bookName.trim().isEmpty() && bookAuthor.trim().isEmpty()) {
			return "redirect:/books/list";
		}else {
			List<Book> books = bookServiceImpl.searchBy(bookName, bookAuthor);
			model.addAttribute("Books", books);
			
		}
		
		return "showBookList";
		
	}

}
