package com.book.objects;

import java.io.Serializable;

public class Book implements Serializable {

	private static final long serialVersionUID = 1L;

	private String title;
	private String isbn;
	private String author;
	private int noOfPages;
	private double price;

	Book() {
	}

	public Book(String title, String isbn, String author, int noOfPages, double price) {
		this.title = title;
		this.isbn = isbn;
		this.author = author;
		this.noOfPages = noOfPages;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getNoOfPages() {
		return noOfPages;
	}

	public void setNoOfPages(int noOfPages) {
		this.noOfPages = noOfPages;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String toString() {
		return this.title + ", " + "by " + this.author;
	}
}
