/**
 * 
 */
package com.epam.library.beans;

/**
 * @author Eugene13
 *
 */
public class Orders {
	private int orderId;
	private Book book;
	private User user;
	private OrderStatus orderStatus;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Override
	public String toString() {
		String infoAboutOrder = String.format("%s  /  %s  /  %s", this.book.getBookName(), this.user.getName(),
				orderStatus.getOrderStatus());
		return infoAboutOrder;
	}
}
