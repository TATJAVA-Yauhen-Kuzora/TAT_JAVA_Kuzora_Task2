package com.epam.library.bean;

import java.io.Serializable;

/**
 * Beans Class {@link OrderStatus}.
 * <P>
 * Class OrderStatus includes 3 fields ({@link #serialVersionUID},
 * {@link #orderStatusId}, {@link #orderStatus}), getters and setters for
 * changeable fields, methods {@link #hashCode()} and {@link #equals(Object)}.
 * <P>
 * <i>This Class is a member of the {@link com.epam.library.bean} package.</i>
 */
public class OrderStatus implements Serializable {
	/**
	 * SerialVersionUID for object of {@link OrderStatus} Class.
	 */
	private static final long serialVersionUID = 4221507743935693602L;
	/**
	 * Contains unique order status id from
	 * library.order_status.order_status_id.
	 */
	private int orderStatusId;
	/**
	 * Contains description for order status from
	 * library.order_status.order_status.
	 */
	private String orderStatus;

	/**
	 * Getter getOrderStatusId.
	 * 
	 * @return unique order status id
	 */
	public int getOrderStatusId() {
		return orderStatusId;
	}

	/**
	 * Setter setOrderStatusId.
	 * 
	 * @param orderStatusId
	 *            the unique order status id to set
	 */
	public void setOrderStatusId(int orderStatusId) {
		this.orderStatusId = orderStatusId;
	}

	/**
	 * Getter getOrderStatus.
	 * 
	 * @return description for order status
	 */
	public String getOrderStatus() {
		return orderStatus;
	}

	/**
	 * Setter setOrderStatus.
	 * 
	 * @param orderStatus
	 *            the description for order status to set
	 */
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	/**
	 * Method hashCode.
	 * 
	 * @return unique hashCode for {@link OrderStatus} object
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderStatus == null) ? 0 : orderStatus.hashCode());
		result = prime * result + orderStatusId;
		return result;
	}

	/**
	 * Method equals.
	 * 
	 * @param obj
	 *            the reference object with which to compare
	 * @return boolean value as the result of comparing {@link OrderStatus}
	 *         objects
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderStatus other = (OrderStatus) obj;
		if (orderStatus == null) {
			if (other.orderStatus != null)
				return false;
		} else if (!orderStatus.equals(other.orderStatus))
			return false;
		if (orderStatusId != other.orderStatusId)
			return false;
		return true;
	}
}
