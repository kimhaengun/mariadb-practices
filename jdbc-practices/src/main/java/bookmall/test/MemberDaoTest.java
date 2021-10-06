package bookmall.test;

import bookmall.dao.MemberDao;
import bookmall.vo.MemberVo;

public class MemberDaoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		insertTest();
		findByAll();
	}

	private static void findByAll() {
		// TODO Auto-generated method stub
		MemberDao dao = new MemberDao();
		dao.findAll();
	}

	private static void insertTest() {
		// TODO Auto-generated method stub
		MemberVo vo = null;
		MemberDao dao = new MemberDao();
		vo = new MemberVo();
		vo.setName("김김김");
		vo.setPassword("1234");
		vo.setEmail("a1@naver.com");
		vo.setPhone("010-1111-1111");
		dao.insert(vo);
		System.out.println("유저 insert 끝");
		
	}

}
