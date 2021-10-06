package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateTest02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DeptVo deptvo = new DeptVo();
		deptvo.setNo(8L);
		deptvo.setName("전략기획팀");

		Boolean result = update(deptvo);
		if(result) {
			System.out.println("update 성공");
		}
	}
	private static Boolean update(DeptVo deptvo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//1. JDBC 드라이버 로딩
			Class.forName("org.mariadb.jdbc.Driver");
			
			//2. 연결하기
			//   연결 url 필요
			String url = "jdbc:mysql://127.0.0.1:3306/employees?charset=utf-8";
			 conn = DriverManager.getConnection(url, "hr", "hr");
			System.out.println("DB 연결 성공");
			
			//3. Statement 생성
			String sql = "update dept set name= ? where no = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			//4.SQL 실행하기
			//insert, update, delete 문 == executeUpdate
			//결과 값이 int
			pstmt.setString(1, deptvo.getName());
			pstmt.setLong(2, deptvo.getNo());
			int count = pstmt.executeUpdate();
			
			result = count == 1;
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패 : "+e);
		}catch(SQLException e) {
			System.out.println("error : "+e);
		}finally {
			try {
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
