package com.epam.library.bean;

import java.io.Serializable;

/**
 * Beans Class {@link Order}.
 * <P>
 * Class Order includes 5 fields ({@link #serialVersionUID}, {@link #orderId},
 * {@link #book}, {@link #user}, {@link #orderStatus}), getters and setters for
 * changeable fields, methods {@link #hashCode()} and {@link #equals(Object)}.
 * <P>
 * <i>This Class is a member of the {@link com.epam.library.bean} package.</i>
 */
public class Order implements Serializable {
	/**
	 * SerialVersionUID for object of {@link Order} Class.
	 */
	private static final long serialVersionUID = -1459342436520010549L;
	/**
	 * Contains unique order id from library.orders.order_id.
	 */
	private int orderId;
	/**
	 * Contains {@link Book} object from library.book.
	 */
	private Book book;
	/**
	 * Contains {@link User} object from library.user.
	 */
	private User user;
	/**
	 * Contains {@link OrderStatus} object from library.order_status.
	 */
	private OrderStatus orderStatus;

	/**
	 * Getter getOrderId.
	 * 
	 * @return unique order id
	 */
	public int getOrderId() {
		return orderId;
	}

	/**
	 * Setter setOrderId.
	 * 
	 * @param orderId
	 *            the unique order id to set
	 */
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	/**
	 * Getter getBook.
	 * 
	 * @return book as object of {@link Book} Class
	 */
	public Book getBook() {
		return book;
	}

	/**
	 * Setter setBook.
	 * 
	 * @param book
	 *            the book as object of {@link Book} Class to set
	 */
	public void setBook(Book book) {
		this.book = book;
	}

	/**
	 * Getter getUser.
	 * 
	 * @return user as object of {@link User} Class
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Setter setUser.
	 * 
	 * @param user
	 *            the user as object of {@link User} Class to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * Getter getOrderStatus.
	 * 
	 * @return orderStatus as object of {@link OrderStatus} Class
	 */
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	/**
	 * Setter setOrderStatus.
	 * 
	 * @param orderStatus
	 *            the orderStatus as object of {@link OrderStatus} Class to set
	 */
	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	/**
	 * Method toString.
	 * 
	 * @return summary info about order
	 */
	@Override
	public String toString() {
		String infoAboutOrder = String.format("%s  /  %s  /  %s", this.book.getBookName(), this.user.getName(),
				orderStatus.getOrderStatus());
		return infoAboutOrder;
	}

	/**
	 * Method hashCode.
	 * 
	 * @return unique hashCode for {@link Order} object
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((book == null) ? 0 : book.hashCode());
		result = prime * result + orderId;
		result = prime * result + ((orderStatus == null) ? 0 : orderStatus.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	/**
	 * Method equals.
	 * 
	 * @param obj
	 *            the reference object with which to compare
	 * @return boolean value as the result of comparing {@link Order} objects
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (book == null) {
			if (other.book != null)
				return false;
		} else if (!book.equals(other.book))
			return false;
		if (orderId != other.orderId)
			return false;
		if (orderStatus == null) {
			if (other.orderStatus != null)
				return false;
		} else if (!orderStatus.equals(other.orderStatus))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
}
