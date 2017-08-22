package com.bookapp;

import java.util.List;
import java.util.Set;

public interface BookStore {

    Object book = null;
	void add(String category, Book book);

    void getInventory();
	public void getCatagories();
	public void getBookByTitle(String bookTitle);
	List<Book> listBookCatogories(int getBookByCatagory);
    Set<String> getAllCategoriesFromInventory();
}
