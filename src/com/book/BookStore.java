package com.book;

public interface BookStore {

	void add(String category, Book book);
	void getInventory();
	void listBookCatogories();
//	public void getBookNameByTittle(String BookTittle);
//	void getBookOnIsbn();
}
