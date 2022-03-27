package com.ssafy.backend.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssafy.backend.dto.User;
import com.ssafy.backend.util.DBUtil;

public class UserDaoImpl implements UserDao {
	private static UserDao instance = new UserDaoImpl();
	private UserDaoImpl() {
		
	}
	public static UserDao getInstance() {
		return instance;
	}
	
	DBUtil util = DBUtil.getInstance();
	@Override
	public User select(String id) throws SQLException {
		String sql = "select * from user where id=?";
		User user = null;
		try(Connection con = util.getConnection();
			PreparedStatement ps = con.prepareStatement(sql)){
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				user = new User(rs.getString("id"), rs.getString("pass"), rs.getString("name"), 
						rs.getString("rec_id"));
				
			}
			util.close(rs);
			
		}
		return user;
	}

}
