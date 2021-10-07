package bookmall.test;

import bookmall.dao.BookDao;
import bookmall.vo.BookVo;

public class BookDaoTest {
	public static void main(String[] args) {
//		insertTest();
		findByAll();
	}

	private static void findByAll() {
		// TODO Auto-generated method stub
		BookDao dao = new BookDao();
		dao.findAll();
		
	}

	private static void insertTest() {
		// TODO Auto-generated method stub
		BookVo vo = null;
		vo = new BookVo();
		BookDao dao = new BookDao();
		vo.setTitle("이클립스");
		vo.setPrice(50000L);
		vo.setCategoryNo(1l);
		dao.insert(vo);
		

		vo.setTitle("자바");
		vo.setPrice(30000L);
		vo.setCategoryNo(1l);
		dao.insert(vo);
		
		vo.setTitle("경제가 뭐죠");
		vo.setPrice(10000L);
		vo.setCategoryNo(2l);
		dao.insert(vo);
		
	}
}
