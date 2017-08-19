package com.book;

import java.util.Scanner;

public class MyBookStoreApplication {

	BookStore higginBothem = new HigginBothamBookStore();

	public void getMethodForBook() {

		// higginBothem.getInventory();
		System.out.println("java books press-1");
		System.out.println("sql books press-2");
		System.out.println("HTML books press-3");
		System.out.println("Spring books press-4");
		Scanner getbook = new Scanner(System.in);
		System.out.println("enter the book catogory");
		int GetCatagory = getbook.nextInt();
		higginBothem.listBookCatogories(GetCatagory);
		System.out
				.println("Search by ISBN : PRESS-1  TITLE : PRESS-2  Author: PRESS-3");
		System.out.println("enter the search method");
		int getInput = getbook.nextInt();
		higginBothem.getCatagories(getInput);
		getbook.close();

	}

	public static void main(String[] args) {

		// higginBothem.add("Java", new Book("sample java book", "1239098",
		// "cassim
		// risvi", 23223, 167.0));
		MyBookStoreApplication obj = new MyBookStoreApplication();
		try {
			obj.getMethodForBook();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Enter correct Input");
			obj.getMethodForBook();
		}
	}

}
