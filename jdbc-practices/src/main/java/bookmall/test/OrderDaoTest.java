package bookmall.test;

import bookmall.dao.OrderDao;
import bookmall.vo.OrderVo;

public class OrderDaoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		insert();
		findByAll();
	}

	private static void findByAll() {
		// TODO Auto-generated method stub
		OrderDao dao = new OrderDao();
		dao.findAll();
	}

	private static void insert() {
		// TODO Auto-generated method stub
		OrderVo vo = new OrderVo();
		OrderDao dao = new OrderDao();
		vo.setOrderNo(20210101L);
		vo.setPrice(45000L);
		vo.setAddress("부산");
		vo.setMemberNo(1L);
		dao.insert(vo);

	}

}
