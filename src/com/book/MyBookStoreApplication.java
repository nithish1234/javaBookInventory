package com.book;

public class MyBookStoreApplication {

	public static void main(String[] args) {
		BookStore higginBothem = new HigginBothamBookStore();
//		higginBothem.add("Java", new Book("sample java book", "1239098", "cassim risvi", 23223, 167.0));
		higginBothem.getInventory();
		higginBothem.listBookCatogories();
//		higginBothem.getBookOnIsbn();
		}

} 