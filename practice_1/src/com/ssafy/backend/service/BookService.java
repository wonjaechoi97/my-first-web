package com.ssafy.backend.service;

import java.sql.SQLException;
import java.util.List;
import com.ssafy.backend.dto.Book;

public interface BookService {
int insert(Book book)throws SQLException;
	
	Book select(String isbn) throws SQLException;
	
	List<Book> select()throws SQLException;
	
	int delete(String isbn) throws SQLException;
}
