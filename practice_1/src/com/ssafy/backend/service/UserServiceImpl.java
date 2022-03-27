package com.ssafy.backend.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssafy.backend.dao.UserDao;
import com.ssafy.backend.dao.UserDaoImpl;
import com.ssafy.backend.dto.User;
import com.ssafy.backend.util.DBUtil;

public class UserServiceImpl implements UserService {
	private static UserService instance = new UserServiceImpl();
	private UserServiceImpl() {
		
	}
	public static UserService getInstance() {
		return instance;
	}
	
	UserDao dao = UserDaoImpl.getInstance();
	@Override
	public User select(String id) throws SQLException {
		
		return dao.select(id);
	}

}
