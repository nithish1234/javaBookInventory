package com.book;

import java.util.ArrayList;
import java.util.Scanner;

public class ListBook {

	public void booksample() {
		try {
			Scanner book = new Scanner(System.in);
			ArrayList<String> booklist = new ArrayList<>();
			booklist.add("javatpoint");
			booklist.add("oracle");
			booklist.add("javasample");
			booklist.add("javatutorial");

			ArrayList<String> sqlbooklist = new ArrayList<>();
			sqlbooklist.add("sqlbook");
			sqlbooklist.add("sqlyog book");
			sqlbooklist.add("sample sql");
			sqlbooklist.add("refrence sql");
			System.out.println("java books press 1");
			System.out.println("sql books press 2");

			System.out.println("Enter the book catogory number");
			int catogoryNumber = book.nextInt();
			if (catogoryNumber == 1) {
				System.out.println(booklist);
			}
			if (catogoryNumber == 2) {
				System.out.println(sqlbooklist);
			}

			System.out.println("Enter the book you want ");
			String bookName = book.next();
			if (booklist.contains(bookName) || sqlbooklist.contains(bookName)) {
				System.out.println("yes the book is avalible");
			} else {
				System.out.println("the book entered is not avalible");
			}
		} catch (Exception e) {
			System.err.println("something went wrong");

		}

	}

	public static void main(String[] args) {
		ListBook obj = new ListBook();
		obj.booksample();
	}
}
