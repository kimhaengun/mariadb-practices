package bookmall.vo;
//주문_책
public class OrderBookVo {
	private Long amount; //수량
	private Long price; // 가격
	private Long bookNo; //책 no
	private Long orderNo; //주문 no
	@Override
	public String toString() {
		return "OrderBookVo [amount=" + amount + ", price=" + price + ", bookNo=" + bookNo + ", orderNo=" + orderNo
				+ "]";
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public Long getBookNo() {
		return bookNo;
	}
	public void setBookNo(Long bookNo) {
		this.bookNo = bookNo;
	}
	public Long getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}
}
