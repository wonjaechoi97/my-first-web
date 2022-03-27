package com.ssafy.backend.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.ssafy.backend.dto.Book;
import com.ssafy.backend.util.DBUtil;

public class BookDaoImpl implements BookDao {
	private static BookDao instance = new BookDaoImpl();
	private BookDaoImpl() {
		
	}
	public static BookDao getInstance() {
		return instance;
	}
	
	DBUtil util = DBUtil.getInstance();
	@Override
	public int insert(Book book) throws SQLException {
		int result=0;
		String sql = "insert into book values (?,?,?,?,?,?)";
		try(Connection con = util.getConnection();
			PreparedStatement ps = con.prepareStatement(sql)){
			ps.setString(1, book.getIsbn());
			ps.setString(2, book.getTitle());
			ps.setString(3, book.getAuthor());
			ps.setInt(4, book.getPrice());
			ps.setString(5, book.getDesc());
			ps.setString(6, book.getImg());
			result = ps.executeUpdate();
			
		}
		return result;
	}

	@Override
	public Book select(String isbn) throws SQLException {
		Book book = null;
		String sql = "select * from book where isbn=?";
		try(Connection con = util.getConnection();
			PreparedStatement ps = con.prepareStatement(sql)
				){
			ps.setString(1, isbn);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				book = new Book(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4),rs.getString(5), rs.getString(6));
			}
			util.close(rs);
		}
		return book;
	}

	@Override
	public List<Book> select() throws SQLException {
		List<Book> list = new ArrayList<Book>();
		String sql="select * from book";
		try(Connection con = util.getConnection();
			PreparedStatement ps = con.prepareStatement(sql)
				){
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				Book b = new Book(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4),rs.getString(5), rs.getString(6));
				list.add(b);
			}
			util.close(rs);
		}
		return list;
	}

	@Override
	public int delete(String isbn) throws SQLException {
		String sql = "delete from book where isbn=?";
		int result=0;
		try(Connection con = util.getConnection();
			PreparedStatement ps = con.prepareStatement(sql)
				){
			ps.setString(1, isbn);
			result=ps.executeUpdate();
			
		}
		return result;
	}

}
