/**
 * 
 */
package com.epam.library.beans;

/**
 * @author Eugene13
 *
 */
public class Book {
	private int bookId;
	private String bookName;
	private String author;
	private BookStatus bookStatus;

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the bookStatus
	 */
	public BookStatus getBookStatus() {
		return bookStatus;
	}

	/**
	 * @param bookStatus
	 *            the bookStatus to set
	 */
	public void setBookStatus(BookStatus bookStatus) {
		this.bookStatus = bookStatus;
	}

	@Override
	public String toString() {
		String allInfoAboultBook = String.format("%s  /  %s  /  %s", this.bookName, this.author,
				this.bookStatus.getBookStatus());
		return allInfoAboultBook;
	}
}
