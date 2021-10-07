package bookmall.test;

import bookmall.dao.OrderBookDao;
import bookmall.vo.OrderBookVo;

public class OrderBookDaoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		insert();
		findByAll();
	}

	private static void findByAll() {
		// TODO Auto-generated method stub
		OrderBookDao dao = new OrderBookDao();
		dao.findAll();
	}

	private static void insert() {
		// TODO Auto-generated method stub
		OrderBookVo vo = new OrderBookVo();
		OrderBookDao dao = new OrderBookDao();
		vo.setAmount(1L);
		vo.setPrice(45000L);
		vo.setBookNo(1L);
		vo.setOrderNo(1L);
		dao.insert(vo);
	}

}
