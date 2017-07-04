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
	private String description;
	private int bookStatusId;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getBookStatusId() {
		return bookStatusId;
	}

	public void setBookStatusId(int bookStatusId) {
		this.bookStatusId = bookStatusId;
	}

}
