package com.csi.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.csi.model.Book;

@Repository
public class BookDaoImpl implements BookDao {

	private SessionFactory factory;

	private Session session;

	@Autowired
	public BookDaoImpl(SessionFactory factory) {
		// TODO Auto-generated constructor stub

		this.factory = factory;

		try {
			session = factory.getCurrentSession();

		} catch (HibernateException e) {
			// TODO: handle exception

			session = factory.openSession();
		}
	}

	@Override
	@Transactional
	public void saveBookData(Book book) {
		// TODO Auto-generated method stub

		Transaction transaction = session.beginTransaction();

		session.save(book);

		transaction.commit();

	}

	@Override
	@Transactional
	public Book findBookById(int bookId) {
		// TODO Auto-generated method stub

		Transaction transaction = session.beginTransaction();

		Book book = session.get(Book.class, bookId);

		transaction.commit();
		return book;
	}

	@Override
	@Transactional
	public List<Book> getAllBookData() {
		// TODO Auto-generated method stub

		Transaction transaction = session.beginTransaction();

		List<Book> bookList = session.createQuery("from Book").list();

		transaction.commit();

		return bookList;
	}

	@Override
	@Transactional
	public void deleteBookById(int bookId) {
		// TODO Auto-generated method stub

		Transaction transaction = session.beginTransaction();

		Book book = session.get(Book.class, bookId);

		session.delete(book);

		transaction.commit();

	}

	@Override
	@Transactional
	public List<Book> searchBy(String bookName, String bookAuthor) {
		// TODO Auto-generated method stub
		
		Transaction transaction = session.beginTransaction();
		
		String query ="";
		
		if(bookName.length() !=0 && bookAuthor.length()!=0) {
			query = "from Book where bookName like '%" + bookName + "%' or bookAuthor like '%" + bookAuthor +"%'";
		} else if(bookName.length()!=0) {
			query = "from Book where bookName like '%" + bookName + "%'";
		} else if(bookAuthor.length()!=0) {
			
			query = "from Book where bookAuthor like '%" + bookAuthor +"%'";
		} else {
			System.out.println("Cannot Search without any input data");
		}
		
		List<Book> books= session.createQuery(query).list();
		
		transaction.commit();
		
		return books;
	}

}
