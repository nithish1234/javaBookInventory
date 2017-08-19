package com.book.bookinterface;

import java.util.List;

import com.book.objects.Book;

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
