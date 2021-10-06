package bookmall.test;

import bookmall.dao.CategoryDao;
import bookmall.vo.CategoryVo;

public class CategoryTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		insertTest();
		findAllTest();
	}

	private static void findAllTest() {
		// TODO Auto-generated method stub
		CategoryDao dao = new CategoryDao();
		dao.findAll();
		
	}

	private static void insertTest() {
		// TODO Auto-generated method stub
		CategoryVo vo = null;
		CategoryDao dao = null;
		vo = new CategoryVo();
		dao = new CategoryDao();
		vo.setName("컴퓨터");
		dao.insert(vo);

		vo = new CategoryVo();
		dao = new CategoryDao();
		vo.setName("경제");
		dao.insert(vo);

		vo = new CategoryVo();
		dao = new CategoryDao();
		vo.setName("예술");
		dao.insert(vo);
		
	}

}
