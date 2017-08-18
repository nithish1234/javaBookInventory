package com.book;

import java.util.List;

public interface BookStore {

	void add(String category, Book book);

	void getInventory();

	void getInputFromUser();

	void getBookByTitle(String bookTitle);

	void getBookByAuthor(String bookAuthor);

	void getBookByISBN(String getIsbn);

	List<Book> listBookCatogories(int getBookByCatagory);

	void getCatagories(int SearchBook);

}
