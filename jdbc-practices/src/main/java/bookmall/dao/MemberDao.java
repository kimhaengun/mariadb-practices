package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.CategoryVo;
import bookmall.vo.MemberVo;

//고객
public class MemberDao {
	public List<MemberVo> findAll() {
		// TODO Auto-generated method stub
		List<MemberVo> result = new ArrayList<MemberVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			
			String sql = "select no,name,password,email,phone from member";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Long no = rs.getLong(1);
				String name = rs.getString(2);
				String password = rs.getString(3);
				String email = rs.getString(4);
				String phone = rs.getString(5);
				
				MemberVo vo = new MemberVo();
				vo.setNo(no);
				vo.setName(name);
				vo.setPassword(password);
				vo.setEmail(email);
				vo.setPhone(phone);
				result.add(vo);
			}
			
			for(MemberVo vo : result) {
				String info = String.format("[%d] 유저 정보 : %s, %s, %s, %s ", vo.getNo(),vo.getName(),vo.getPassword(),vo.getEmail(),vo.getPhone());
				System.out.println(info);
			}

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
	
	public boolean insert(MemberVo vo) {
		boolean result = false;
		Connection conn =null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			
			String sql = "insert into member values(null,?,password(?),?,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getPhone());
			
			int count = pstmt.executeUpdate();
			
			System.out.println(vo.getName()+" : "+ vo.getEmail()+" : "+vo.getPhone());
			result = count ==1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("SQL error : "+e);
		}finally {
			try {
				if(conn != null) {
					conn.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}		
			}catch (SQLException e) {
				System.out.println("SQL error : "+e);
			}
			
		}
		return result;
	}//end insert
	
	
	//Connection
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			//1. JDBC 드라이버 로딩
			Class.forName("org.mariadb.jdbc.Driver");
			//2. 연결하기
			//   연결 url 필요
			String url = "jdbc:mysql://127.0.0.1:3306/bookmall?charset=utf-8";
			conn = DriverManager.getConnection(url, "bookmall", "bookmall");
//			System.out.println("DB 연결 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("드라이버 로딩 실패 : "+e);
		}

		return conn;
	}// end Connection
}
