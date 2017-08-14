package com.book;

public interface BookStore {

	void add(String category, Book book);
	void getInventory();
	public void getBookOnIsbn(String isbn);
}
