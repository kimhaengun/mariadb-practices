package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.BookVo;
import bookmall.vo.CartVo;

//카트
public class CartDao {
	public List<CartVo> findAll() {
		// TODO Auto-generated method stub
		List<CartVo> result = new ArrayList<CartVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			
			String sql = "select c.count as count ,c.book_no as bookNo,c.member_no as memberNo,b.title as bookTitle \r\n"
					+ "from cart c, book b where c.book_no = b.no";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Long count = rs.getLong(1);
				Long bookNo = rs.getLong(2);
				Long memberNo = rs.getLong(3);
				String bookTitle = rs.getString(4);
				
				CartVo vo = new CartVo();
				vo.setCount(count);
				vo.setBookNo(bookNo);
				vo.setMemberNo(memberNo);
				vo.setBookTitle(bookTitle);
				result.add(vo);
			}
			
			for(CartVo vo : result) {
				String info = String.format("수량 : %d,책번호 : %d,유저번호 : %d,책이름 : %s",vo.getCount(),vo.getBookNo(),vo.getMemberNo(),vo.getBookTitle());
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
	//insert
	public boolean insert(CartVo vo) {
		boolean result = false;
		Connection conn =null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			
			String sql = "insert into cart values(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setLong(1, vo.getCount());
			pstmt.setLong(2, vo.getBookNo());
			pstmt.setLong(3, vo.getMemberNo());
			
			int count = pstmt.executeUpdate();
			
			System.out.println("수량 : "+vo.getCount()+", 책번호 : "+ vo.getBookNo()+", 유저번호 : "+vo.getMemberNo());
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
