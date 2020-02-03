package com.example.Bookstore.domain;

public class Book {
	private String title;
	private String author;
	private int year;
	private String isbn;
	private long price;

	public Book(String title, String author, int year, String isbn, long price) {
		this.setAuthor(author);
		this.setIsbn(isbn);
		this.setPrice(price);
		this.setTitle(title);
		this.setYear(year);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}
}
