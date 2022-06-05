package com.csi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csi.dao.BookDao;
import com.csi.model.Book;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookDao bookDaoImpl;

	@Override
	public void saveBookData(Book book) {
		// TODO Auto-generated method stub
		bookDaoImpl.saveBookData(book);
	}

	@Override
	public Book findBookById(int bookId) {
		// TODO Auto-generated method stub
		return bookDaoImpl.findBookById(bookId);
	}

	@Override
	public List<Book> getAllBookData() {
		// TODO Auto-generated method stub
		return bookDaoImpl.getAllBookData();
	}

	@Override
	public void deleteBookById(int bookId) {
		// TODO Auto-generated method stub
		bookDaoImpl.deleteBookById(bookId);
	}

	@Override
	public List<Book> searchBy(String bookName, String bookAuthor) {
		// TODO Auto-generated method stub
		return bookDaoImpl.searchBy(bookName, bookAuthor);
	}

}
