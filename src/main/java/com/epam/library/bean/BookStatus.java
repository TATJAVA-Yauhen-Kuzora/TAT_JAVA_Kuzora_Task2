package com.epam.library.bean;

import java.io.Serializable;

/**
 * Beans Class {@link BookStatus}.
 * <P>
 * Class BookStatus includes 2 fields ({@link #serialVersionUID},
 * {@link #bookStatusId}, ), getters and setters for changeable fields, methods
 * hashCode and equals.
 * </p>
 * <P>
 * <i>This Class is a member of the {@link com.epam.library.bean} package.</i>
 * </p>
 */
public class BookStatus implements Serializable {
	/**
	 * SerialVersionUID for object of {@link BookStatus} Class.
	 */
	private static final long serialVersionUID = -3305976644939679901L;
	/**
	 * Contains unique book status id from library.book_status.book_status_id.
	 */
	private int bookStatusId;
	/**
	 * Contains description of book status id from
	 * library.book_status.book_status.
	 */
	private String bookStatus;

	/**
	 * Getter getBookStatusId.
	 * 
	 * @return unique book status id
	 */
	public int getBookStatusId() {
		return bookStatusId;
	}

	/**
	 * Setter setBookStatusId.
	 * 
	 * @param bookStatusId
	 *            the unique book status id to set
	 */
	public void setBookStatusId(int bookStatusId) {
		this.bookStatusId = bookStatusId;
	}

	/**
	 * Getter getBookStatus.
	 * 
	 * @return description of book status
	 */
	public String getBookStatus() {
		return bookStatus;
	}

	/**
	 * Setter setBookStatus.
	 * 
	 * @param bookStatus
	 *            the description of book status to set
	 */
	public void setBookStatus(String bookStatus) {
		this.bookStatus = bookStatus;
	}

	/**
	 * Method hashCode.
	 * 
	 * @return unique hashCode for {@link BookStatus} object
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookStatus == null) ? 0 : bookStatus.hashCode());
		result = prime * result + bookStatusId;
		return result;
	}

	/**
	 * Method equals.
	 * 
	 * @param obj
	 *            the reference object with which to compare
	 * @return boolean value as the result of comparing {@link BookStatus}
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
		BookStatus other = (BookStatus) obj;
		if (bookStatus == null) {
			if (other.bookStatus != null)
				return false;
		} else if (!bookStatus.equals(other.bookStatus))
			return false;
		if (bookStatusId != other.bookStatusId)
			return false;
		return true;
	}
}
