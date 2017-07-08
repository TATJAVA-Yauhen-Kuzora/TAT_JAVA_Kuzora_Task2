package com.epam.library.bean;

import java.io.Serializable;

/**
 * Beans Class {@link Book}.
 * <P>
 * Class Book includes 5 fields ({@link #serialVersionUID}, {@link #bookId},
 * {@link #bookName}, {@link #author}, {@link #bookStatus}), getters and setters
 * for changeable fields, methods {@link #hashCode()} and
 * {@link #equals(Object)}.
 * <P>
 * <i>This Class is a member of the {@link com.epam.library.bean} package.</i>
 */
public class Book implements Serializable {
	/**
	 * SerialVersionUID for object of {@link Book} Class.
	 */
	private static final long serialVersionUID = -6465256830336425938L;
	/**
	 * Contains unique book_id from library.book.book_id.
	 */
	private int bookId;
	/**
	 * Contains book name from library.book.book_name.
	 */
	private String bookName;
	/**
	 * Contains author name from library.book.author.
	 */
	private String author;
	/**
	 * Contains {@link BookStatus} Object as summary info about book available
	 * property from library.book_status.
	 */
	private BookStatus bookStatus;

	/**
	 * Getter getBookId.
	 * 
	 * @return unique book id
	 */
	public int getBookId() {
		return bookId;
	}

	/**
	 * Setter setBookId.
	 * 
	 * @param bookId
	 *            the unique book id to set
	 */
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	/**
	 * Getter getBookName.
	 * 
	 * @return bookName
	 */
	public String getBookName() {
		return bookName;
	}

	/**
	 * Setter setBookName.
	 * 
	 * @param bookName
	 *            the book name to set
	 */
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	/**
	 * Getter getAuthore.
	 * 
	 * @return author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * Setter setAuthor.
	 * 
	 * @param author
	 *            the author name to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * Getter getBookStatus.
	 * 
	 * @return bookStatus as object of {@link BookStatus} Class
	 */
	public BookStatus getBookStatus() {
		return bookStatus;
	}

	/**
	 * Setter setBookStatus.
	 * 
	 * @param bookStatus
	 *            the bookStatus as object of {@link BookStatus} Class to set
	 */
	public void setBookStatus(BookStatus bookStatus) {
		this.bookStatus = bookStatus;
	}

	/**
	 * Method toString.
	 * 
	 * @return summary info about book
	 */
	@Override
	public String toString() {
		String allInfoAboultBook = String.format("%s  /  %s  /  %s", this.bookName, this.author,
				this.bookStatus.getBookStatus());
		return allInfoAboultBook;
	}

	/**
	 * Method hashCode.
	 * 
	 * @return unique hashCode for {@link Book} object
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + bookId;
		result = prime * result + ((bookName == null) ? 0 : bookName.hashCode());
		result = prime * result + ((bookStatus == null) ? 0 : bookStatus.hashCode());
		return result;
	}

	/**
	 * Method equals.
	 * 
	 * @param obj
	 *            the reference object with which to compare
	 * @return boolean value as the result of comparing {@link Book} objects
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (bookId != other.bookId)
			return false;
		if (bookName == null) {
			if (other.bookName != null)
				return false;
		} else if (!bookName.equals(other.bookName))
			return false;
		if (bookStatus == null) {
			if (other.bookStatus != null)
				return false;
		} else if (!bookStatus.equals(other.bookStatus))
			return false;
		return true;
	}
}
