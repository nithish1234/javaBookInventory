package com.book;

import java.util.Scanner;

public class MyBookStoreApplication {

	BookStore higginBothem = new HigginBothamBookStore();
	Scanner getbook = new Scanner(System.in);

	public void getMethodForBook() {
		try {
			higginBothem.getInventory();
			System.out.println("java books press-1");
			System.out.println("sql books press-2");
			System.out.println("HTML books press-3");
			System.out.println("Spring books press-4");

			System.out.println("enter the book catogory");
			int GetCatagory = getbook.nextInt();
			higginBothem.listBookCatogories(GetCatagory);
			System.out.println("Search by 1)ISBN 2)TITLE 3)Author");
			System.out.println("enter the search method");
			int getInput = getbook.nextInt();
			higginBothem.getCatagories(getInput);
			getbook.close();
		} catch (Exception e) {
System.err.println("enter correct input");
		}
	}

	public static void main(String[] args) {

		// higginBothem.add("Java", new Book("sample java book", "1239098", "cassim
		// risvi", 23223, 167.0));
		MyBookStoreApplication obj = new MyBookStoreApplication();
		obj.getMethodForBook();
	}

}
