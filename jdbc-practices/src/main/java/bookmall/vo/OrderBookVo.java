package bookmall.vo;
//주문_책
public class OrderBookVo {
	private Long amount; //수량
	private Long price; // 가격
	private Long bookNo; //책 no
	private Long orderNo; //주문 no
	private String bookTitle;
	private String orderAddress;
	private Long orderOrderNo;
	
	@Override
	public String toString() {
		return "OrderBookVo [amount=" + amount + ", price=" + price + ", bookNo=" + bookNo + ", orderNo=" + orderNo
				+ ", bookTitle=" + bookTitle + ", morderAddress=" + orderAddress + ", orderOrderNo=" + orderOrderNo
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
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getorderAddress() {
		return orderAddress;
	}
	public void setorderAddress(String orderAddress) {
		this.orderAddress = orderAddress;
	}
	public Long getOrderOrderNo() {
		return orderOrderNo;
	}
	public void setOrderOrderNo(Long orderOrderNo) {
		this.orderOrderNo = orderOrderNo;
	}

	
}
