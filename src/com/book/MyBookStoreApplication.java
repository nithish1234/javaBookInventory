package com.book;

public class MyBookStoreApplication {

	public static void main(String[] args) {
		BookStore higginBothem = new HigginBothamBookStore();
		higginBothem.getInventory();

		higginBothem.add("Java", new Book("Test Java Book", "123", "Esakki", 23, 67.0));
		higginBothem.getInventory();
		higginBothem.getBookOnIsbn("123");
		
	}

}
