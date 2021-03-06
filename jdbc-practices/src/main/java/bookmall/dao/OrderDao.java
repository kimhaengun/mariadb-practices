package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.CartVo;
import bookmall.vo.OrderVo;

//주문
public class OrderDao {
	public List<OrderVo> findAll() {
		// TODO Auto-generated method stub
		List<OrderVo> result = new ArrayList<OrderVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			
			String sql = "select mo.no,mo.orderno,mo.price,mo.address,mo.member_no,m.name \r\n"
					+ "from morder mo, member m where mo.member_no = m.no";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Long no = rs.getLong(1);
				Long orderNo = rs.getLong(2);
				Long price = rs.getLong(3);
				String address = rs.getString(4);
				Long memberNo = rs.getLong(5);
				String name = rs.getString(6);
				
				OrderVo vo = new OrderVo();
				vo.setNo(no);
				vo.setOrderNo(orderNo);
				vo.setPrice(price);
				vo.setAddress(address);
				vo.setMemberNo(memberNo);
				vo.setMemberName(name);
				result.add(vo);
			}
			
			for(OrderVo vo : result) {
				String info = String.format("번호 : %d, 주문번호 : %d, 가격 : %d, 주소 : %s, 유저번호 : %d, 유저이름 : %s",vo.getNo(),vo.getOrderNo(),vo.getPrice(),vo.getAddress(),vo.getMemberNo(),vo.getMemberName());
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
	public boolean insert(OrderVo vo) {
		boolean result = false;
		Connection conn =null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			
			String sql = "insert into morder values(null,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setLong(1, vo.getOrderNo());
			pstmt.setLong(2, vo.getPrice());
			pstmt.setString(3, vo.getAddress());
			pstmt.setLong(4, vo.getMemberNo());
			
			int count = pstmt.executeUpdate();
			
			System.out.println("주문번호 : "+ vo.getOrderNo()+", 가격 : "+vo.getPrice()+", 주소 : "+vo.getAddress()+", 유저번호 : "+vo.getMemberNo());
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
