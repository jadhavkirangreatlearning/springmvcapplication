package com.csi.dao;

import java.util.List;

import com.csi.model.Book;

public interface BookDao {
	
	public void saveBookData(Book book);
	
	public Book findBookById(int bookId);
	
	public List<Book> getAllBookData();
	
	public void deleteBookById(int bookId);
	
	public List<Book> searchBy(String bookName, String bookAuthor);

}
