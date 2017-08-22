package com.bookapp;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * This is the class that accepts the user input by displaying the available
 * categories of books and then based on the user selected category, it will
 * list out the books for the user to pick.
 * <p>
 * This class is the starting point as it has the method main in it.
 */
public class MyBookStoreApplication {

	public static void main(String[] args) {

		BookStore higginBothem = new HigginBothamBookStore();
		// HigginBothamBookStore obj=new HigginBothamBookStore();
		String userChosenCategory = getBookCategoryFromUser(higginBothem);
		System.out.println("the tou have selected is " + userChosenCategory);
		if ("sql".equals(userChosenCategory)) {
			List<Book> sqlbooks=HigginBothamBookStore.sqlBooks;
			for(Book book:sqlbooks) {
				System.out.println(book);
			}
		}
		BookStore bookStore = new HigginBothamBookStore();
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the number");
		int sample = sc.nextInt();
		bookStore.listBookCatogories(sample);
		bookStore.getCatagories();

	}

	// getBookCategoryFromUser(BookStore store)
	private static String getBookCategoryFromUser(BookStore store) {
		Scanner userInput = new Scanner(System.in);
		String userChosenCategory = null;

		System.out.println("Below are the categories of books available.");
		Set<String> categories = displayAvailableCategories(store);

		for (String category : categories) {
			System.out.println(category);
		}

		try {
			do {
				System.out.println("Enter valid category (case sensitive) of book that you are looking for.");
				userChosenCategory = userInput.nextLine();

			} while (!categories.contains(userChosenCategory));
		} catch (Exception exception) {
			System.err.println("Something went wrong. Rerun the program to start again!");
		}
		return userChosenCategory;
	}

	private static Set<String> displayAvailableCategories(BookStore store) {
		Set<String> categories = store.getAllCategoriesFromInventory();
		return categories;
	}
	// private void getSearch() {
	//
	//
	// }

	// public void getMethodForBook() {
	//
	// // higginBothem.getInventory();
	// System.out.println("java books press-1");
	// System.out.println("sql books press-2");
	// System.out.println("HTML books press-3");
	// System.out.println("Spring books press-4");
	// Scanner userInput = new Scanner(System.in);
	// System.out.println("enter the book catogory");
	// int userCategory = userInput.nextInt();
	// higginBothem.listBookCatogories(userCategory);
	// System.out.println("Search by ISBN : PRESS-1 TITLE : PRESS-2 Author:
	// PRESS-3");
	// System.out.println("enter the search method");
	// int bookSearchOption = userInput
	// .nextInt();
	// higginBothem.getCatagories(bookSearchOption);
	// userInput.close();
	//
	// }

}
