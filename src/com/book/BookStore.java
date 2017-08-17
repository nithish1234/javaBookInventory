package com.book;

public interface BookStore {

	void add(String category, Book book);
	void getInventory();
	 void getInputFromUser();
	void listBookCatogories(int getBookByCatagory);
	 void getCatagories(int SearchBook);

}
