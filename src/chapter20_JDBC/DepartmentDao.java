package chaper20_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDao {
	//Field
		Connection connection;
		Statement stmt;
		ResultSet rs;
		//Constructor

		public DepartmentDao() {
			try {
			String url = "jdbc:mysql://127.0.0.1:3306/hrdb2019";
			String user = "root";
			String password = "mysql1234";
			Connection connection = DriverManager.getConnection(url,user,password);
			System.out.println("---->> 1단계 성공!!");
			
			//2단계 : Statement 객체 생성
			Statement stmt = connection.createStatement();
			System.out.println("---->> 2단계 성공!!");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
		//2단계 : Statement
		public void getStatement()  {
			//2단계 : Statement객체 생성
		    try {
				stmt = connection.createStatement();
				System.out.println("---->> 2단계 성공!!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		//3단계 : CRUD 기능에 따라 메소드 생성
		public List<DepartmentVo> getList() {
			List<DepartmentVo> list = new ArrayList<DepartmentVo>();
			String sql = """
					select emp_id,
							emp_name,
							hire_date,
							salary
							from employee
					""";
			try {
				rs = stmt.executeQuery(sql);
				while(rs.next()) {
					//rs 객체의 1 row --> EmployeeVo 저장
					DepartmentVo department = new DepartmentVo();
					department.setDeptId(rs.getString(1));
					department.setDeptName(rs.getString(2));
					department.setUnitId(rs.getString(3));
					department.setStartDate(rs.getString(4));
					
					list.add(department);
				}
				
			} catch (Exception e) {e.printStackTrace();}
			
			return list;
		
		}
		
		
		//5단계 : close
		public void close() {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(connection != null) connection.close();
			} catch (Exception e) {e.printStackTrace();}
		}
		
}
