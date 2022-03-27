package com.ssafy.backend.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    /**
     * DB 접속에 필요한 url을 작성한다.
     * url은 jdbc:mysql://[host][:port]/[database][?propertyName1][=propertyValue1]형태로 작성한다.
     * serverTimezone=UTC 설정이 없으면 오류가 발생하므로 주의한다.
     */
    private final String url = "jdbc:mysql://localhost:3306/ssafyweb?serverTimezone=UTC";
    /**
     * DB 접속에 필요한 사용자 계정을 작성한다. 각자 DB마다 다를 수 있다.
     */
    private final String user = "ssafy";
    private final String pass = "ssafy";
    /**
     * 사용할 JDBC 드라이버 이름이다.
     */
    private final String driverName = "com.mysql.cj.jdbc.Driver";

    /**
     * Singleton Design Pattern을 적용해준다.
     */
    //싱글톤으로 DButil만들기
    private static DBUtil util = new DBUtil();
    private DBUtil() {
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

    public static DBUtil getInstance() {
    	return util;
    }
    /**
     * DriverManager를 통해 Connection을 생성하고 반환한다.
     *
     * @return
     * @throws SQLException
     */
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, pass);
    }

    /**
     * 사용한 리소스들을 정리한다.
     * Connection, Statement, ResultSet 모두 AutoCloseable 타입이다.
     * ... 을 이용하므로 필요에 따라서
     * select 계열 호출 후는 ResultSet, Statement, Connection
     * dml 호출 후는 Statement, Connection 등 다양한 조합으로 사용할 수 있다.
     *
     * @param closeables
     */
    public void close(AutoCloseable... closeables) {
       	for (AutoCloseable c : closeables) {
			try {
				if (c != null) c.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
    }
}
