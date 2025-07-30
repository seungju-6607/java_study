package db;

import java.sql.Connection;
import java.sql.Statement;

public class DBConn {
	private String url = "jdbc:mysql://127.0.0.1:3306/hrdb2019";
	private String user = "root";
	private String password = "mysql1234";
	
	Connection connection;
	Statement stmt;
	
	protected DBConn() {
		
	}
}
