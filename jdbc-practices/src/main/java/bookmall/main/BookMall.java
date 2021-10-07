package bookmall.main;

import java.util.List;

import bookmall.dao.BookDao;
import bookmall.dao.CartDao;
import bookmall.dao.CategoryDao;
import bookmall.dao.MemberDao;
import bookmall.dao.OrderBookDao;
import bookmall.dao.OrderDao;
import bookmall.vo.BookVo;
import bookmall.vo.CartVo;
import bookmall.vo.CategoryVo;
import bookmall.vo.MemberVo;
import bookmall.vo.OrderBookVo;
import bookmall.vo.OrderVo;

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
		new CategoryDao().findAll();
		
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
		
		System.out.println("====유저 List====");
		memberdao.findAll();
		
		System.out.println("====책 생성====");
		BookVo bookvo = null;
		BookDao bookdao = new BookDao();
		bookvo = new BookVo();
		bookvo.setTitle("이클립스");
		bookvo.setPrice(50000L);
		bookvo.setCategoryNo(1l);
		bookdao.insert(bookvo);
		
		
		bookvo.setTitle("자바");
		bookvo.setPrice(30000L);
		bookvo.setCategoryNo(1l);
		bookdao.insert(bookvo);
		
		bookvo.setTitle("경제가 뭐죠");
		bookvo.setPrice(10000L);
		bookvo.setCategoryNo(2l);
		bookdao.insert(bookvo);
		
		System.out.println("==== 책 정보 ====");
		bookdao.findAll();
		
		System.out.println("==== 카트 생성 ===");
		CartVo cartVo = new CartVo();
		CartDao cartDao = new CartDao();
		cartVo.setCount(1L);
		cartVo.setBookNo(1L);
		cartVo.setMemberNo(1L);
		cartDao.insert(cartVo);

		cartVo.setCount(1L);
		cartVo.setBookNo(2L);
		cartVo.setMemberNo(2L);
		cartDao.insert(cartVo);
		
		System.out.println("====카트 List ====");
		cartDao.findAll();
		
		System.out.println("==== 주문 리스트 생성====");
		OrderVo orderVo = new OrderVo();
		OrderDao orderDao = new OrderDao();
		orderVo.setOrderNo(20210101L);
		orderVo.setPrice(45000L);
		orderVo.setAddress("부산");
		orderVo.setMemberNo(1L);
		orderDao.insert(orderVo);
		
		System.out.println("==== 주문 List ====");
		new OrderDao().findAll();
		
		System.out.println("==== 주문 책 ====");
		OrderBookVo orderBookVo = new OrderBookVo();
		OrderBookDao orderBookDao = new OrderBookDao();
		orderBookVo.setAmount(1L);
		orderBookVo.setPrice(45000L);
		orderBookVo.setBookNo(1L);
		orderBookVo.setOrderNo(1L);
		orderBookDao.insert(orderBookVo);

		orderBookVo.setAmount(1L);
		orderBookVo.setPrice(27000L);
		orderBookVo.setBookNo(2L);
		orderBookVo.setOrderNo(1L);
		orderBookDao.insert(orderBookVo);
		
		System.out.println("==== 주문 책 List ====");
		new OrderBookDao().findAll();
		
	}

}
