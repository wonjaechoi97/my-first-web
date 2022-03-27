package com.ssafy.backend.service;

import java.sql.SQLException;
import com.ssafy.backend.dto.User;

public interface UserService {
	User select(String id) throws SQLException;
}
