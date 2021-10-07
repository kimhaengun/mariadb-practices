package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.OrderBookVo;
import bookmall.vo.OrderVo;

public class OrderBookDao {
	public List<OrderBookVo> findAll() {
		// TODO Auto-generated method stub
		List<OrderBookVo> result = new ArrayList<OrderBookVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			
			String sql = "select ob.amount, ob.price, b.no as bookNo, mo.no as orderNo,b.title,mo.address,mo.orderno  from order_book ob, morder mo, book b\r\n"
					+ "where ob.book_no = b.no and ob.morder_no = mo.no";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Long amount = rs.getLong(1);
				Long price = rs.getLong(2);
				Long bookNo = rs.getLong(3);
				Long orderNo = rs.getLong(4);
				String bookTitle = rs.getString(5);
				String orderAddress = rs.getString(6);
				Long orderOderNo = rs.getLong(7); 
				
				OrderBookVo vo = new OrderBookVo();
				vo.setAmount(amount);
				vo.setPrice(price);
				vo.setBookNo(bookNo);
				vo.setOrderNo(orderNo);
				vo.setBookTitle(bookTitle);
				vo.setorderAddress(orderAddress);
				vo.setOrderOrderNo(orderNo);
				result.add(vo);
			}
			
			for(OrderBookVo vo : result) {
				String info = String.format("주문번호 : %d, 책번호: : %d, 책이름 : %s, 가격 : %d, 수량 : %d, 주문번호 : %d, 주소 : %s",vo.getOrderOrderNo(),vo.getBookNo(),vo.getBookTitle(),vo.getPrice(),vo.getAmount(),vo.getOrderNo(),vo.getorderAddress());
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
	public boolean insert(OrderBookVo vo) {
		boolean result = false;
		Connection conn =null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			
			String sql = "insert into order_book values(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setLong(1, vo.getAmount());
			pstmt.setLong(2, vo.getPrice());
			pstmt.setLong(3, vo.getBookNo());
			pstmt.setLong(4, vo.getOrderNo());
			
			int count = pstmt.executeUpdate();
			
			System.out.println("주문수량 : "+ vo.getAmount()+", 가격 : "+vo.getPrice()+", 책번호 : "+vo.getBookNo()+", 주문번호 : "+vo.getOrderNo());
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
