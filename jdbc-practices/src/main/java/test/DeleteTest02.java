package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteTest02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Boolean result = delete(6L);
		System.out.println(result ? "성공" : "실패");
	}

	private static Boolean delete(long l) {
		// TODO Auto-generated method stub
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
					
			//4.SQL 실행하기
			String sql = "delete from dept where no = ?";
			//insert, update, delete 문 == executeUpdate
			//결과 값이 int
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setLong(1, l);
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
