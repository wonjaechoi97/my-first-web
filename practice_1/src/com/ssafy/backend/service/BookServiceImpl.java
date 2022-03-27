package com.ssafy.backend.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.backend.dao.BookDao;
import com.ssafy.backend.dao.BookDaoImpl;
import com.ssafy.backend.dto.Book;
import com.ssafy.backend.util.DBUtil;

public class BookServiceImpl implements BookService {
	private static BookService instance = new BookServiceImpl();
	private BookServiceImpl() {
		
	}
	public static BookService getInstance() {
		return instance;
	}
	
	BookDao dao = BookDaoImpl.getInstance();
	@Override
	public int insert(Book book) throws SQLException {
		
		return dao.insert(book);
	}

	@Override
	public Book select(String isbn) throws SQLException {
		
		return dao.select(isbn);
	}

	@Override
	public List<Book> select() throws SQLException {
		
		return dao.select();
	}

	@Override
	public int delete(String isbn) throws SQLException {
		
		return dao.delete(isbn);
	}

}
