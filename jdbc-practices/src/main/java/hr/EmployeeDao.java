package hr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

public class EmployeeDao {
	
	public List<EmployeeVo> findByName(String name) {
		List<EmployeeVo> result = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//1. JDBC 드라이버 로딩
			Class.forName("org.mariadb.jdbc.Driver");
			
			//2. 연결하기
			//   연결 url 필요
			String url = "jdbc:mysql://127.0.0.1:3306/employees?charset=utf-8";
			 conn = DriverManager.getConnection(url, "hr", "hr");
			System.out.println("DB 연결 성공");
			
			//3. Statement 생성
			
			//4.SQL 실행하기
			String sql = "select emp_no, first_name, last_name, date_format(hire_date, '%Y-%m-%d') \r\n"
					+ "from employees where first_name like  ? or last_name like ?";
			//insert, update, delete 문 == executeUpdate
			//결과 값이 int
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "%"+name+"%");
			pstmt.setString(2, "%"+name+"%");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Long empNo = rs.getLong(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				String hireDate = rs.getString(4);
				
				EmployeeVo vo = new EmployeeVo();
				vo.setNo(empNo);
				vo.setFirstName(firstName);
				vo.setLastName(lastName);
				vo.setHireDate(hireDate);
				
				result.add(vo);
				
				System.out.println(empNo+ " : "+ firstName);
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패 : "+e);
		}catch(SQLException e) {
			System.out.println("error : "+e);
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();					
				}
				if(conn != null) {
					conn.close();					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}// end try ~ finally
		return result;
	}
	
	
	public List<EmployeeVo> findBySalary(int minSalary, int maxSalary) {
		List<EmployeeVo> result = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//1. JDBC 드라이버 로딩
			Class.forName("org.mariadb.jdbc.Driver");
			
			//2. 연결하기
			//   연결 url 필요
			String url = "jdbc:mysql://127.0.0.1:3306/employees?charset=utf-8";
			 conn = DriverManager.getConnection(url, "hr", "hr");
			System.out.println("DB 연결 성공");
			
			//3. Statement 생성
			
			//4.SQL 실행하기
			String sql = "select e.emp_no, e.first_name, e.last_name, s.salary from salaries s, employees e "
					+ "where s.emp_no = e.emp_no and s.to_date='9999-01-01' and s.salary >= ? and s.salary <= ?";
			//insert, update, delete 문 == executeUpdate
			//결과 값이 int
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, minSalary);
			pstmt.setInt(2, maxSalary);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Long empNo = rs.getLong(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				int  salary = rs.getInt(4);
				
				EmployeeVo vo = new EmployeeVo();
				vo.setNo(empNo);
				vo.setFirstName(firstName);
				vo.setLastName(lastName);
				vo.setSalary(salary);
				
				result.add(vo);
				
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패 : "+e);
		}catch(SQLException e) {
			System.out.println("error : "+e);
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();					
				}
				if(conn != null) {
					conn.close();					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}// end try ~ finally
		return result;
	}
}
