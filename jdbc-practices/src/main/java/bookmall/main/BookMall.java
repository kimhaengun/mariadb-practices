package bookmall.main;

import java.util.List;

import bookmall.dao.CategoryDao;
import bookmall.vo.CategoryVo;

public class BookMall {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//카테고리 3개 insert
		System.out.println("====카테고리 3 insert====");
		CategoryVo vo = null;
		vo = new CategoryVo();
		vo.setName("컴퓨터");
		new CategoryDao().insert(vo);
		vo=new CategoryVo();
		vo.setName("경제");
		new CategoryDao().insert(vo);
		vo = new CategoryVo();
		vo.setName("예술");
		new CategoryDao().insert(vo);

		System.out.println("====카테고리 List====");
		List<CategoryVo> list = new CategoryDao().findAll();
		
	}

}
