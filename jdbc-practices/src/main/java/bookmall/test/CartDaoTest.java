package bookmall.test;

import bookmall.dao.CartDao;
import bookmall.vo.CartVo;

public class CartDaoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		insertTest();
		findByAll();
	}

	private static void findByAll() {
		// TODO Auto-generated method stub
		CartDao dao = new CartDao();
		dao.findAll();
	}

	private static void insertTest() {
		// TODO Auto-generated method stub
		CartVo vo = null;
		vo = new CartVo();
		vo.setCount(1L);
		vo.setBookNo(1L);
		vo.setMemberNo(1L);
		CartDao dao = new CartDao();
		dao.insert(vo);
		
		vo.setCount(1L);
		vo.setBookNo(2L);
		vo.setMemberNo(2L);
		dao.insert(vo);
	}

}
