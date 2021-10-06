package bookmall.main;

import java.util.List;

import bookmall.dao.CategoryDao;
import bookmall.dao.MemberDao;
import bookmall.vo.CategoryVo;
import bookmall.vo.MemberVo;

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
		
		System.out.println("====유저 생성====");
		MemberVo membervo = null;
		MemberDao memberdao = new MemberDao();
		membervo = new MemberVo();
		membervo.setName("김김김");
		membervo.setPassword("1234");
		membervo.setEmail("a1@naver.com");
		membervo.setPhone("010-1111-1111");
		memberdao.insert(membervo);
		
		membervo = new MemberVo();
		membervo.setName("박박박");
		membervo.setPassword("1234");
		membervo.setEmail("a2@naver.com");
		membervo.setPhone("010-2222-2222");
		memberdao.insert(membervo);
		
		System.out.println("====유저 정보 2명====");
		memberdao.findAll();
	}

}
