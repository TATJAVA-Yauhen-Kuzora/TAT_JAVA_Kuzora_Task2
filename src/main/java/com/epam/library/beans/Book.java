package com.epam.library.beans;

/**
 * Beans Class {@link Book}.
 * <P>
 * Class Book includes 4 fields (bookId, bookName, author, bookStatus).
 * <P>
 * <i>This class is a member of the {@link com.epam.library.beans} package.</i>
 */
public class Book {
	/**
	 * Contains book_id from library.book table.
	 */
	private int bookId;
	/**
	 * Contains book_name from library.book table.
	 */
	private String bookName;
	/**
	 * Contains author from library.book table.
	 */
	private String author;
	/**
	 * Contains {@link BookStatus} Object as summary info about book available
	 * property.
	 */
	private BookStatus bookStatus;

	/**
	 * Getter getBookId.
	 * 
	 * @return bookId
	 */
	public int getBookId() {
		return bookId;
	}

	/**
	 * Setter setBookId.
	 * 
	 * @param bookId
	 *            the bookId to set
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
	 *            the bookName to set
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
	 *            the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * Getter getBookStatus.
	 * 
	 * @return getBookStatus
	 */
	public BookStatus getBookStatus() {
		return bookStatus;
	}

	/**
	 * Setter setBookStatus.
	 * 
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
