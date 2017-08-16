package com.book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class HigginBothamBookStore implements BookStore {
	Scanner getbook = new Scanner(System.in);

	Set<String> categories = new HashSet<>();
	List<Map<String, List<Book>>> inventory = new ArrayList<Map<String, List<Book>>>();
	List<Book> javaBooks = new ArrayList<>();
	List<Book> sqlBooks = new ArrayList<>();
	List<Book> HTMLBooks = new ArrayList<>();
	List<Book> SpringBooks = new ArrayList<>();

	public HigginBothamBookStore() {
		inventory.add(JavaCategoryBooks());
		inventory.add(sqlCategoryBooks());
		inventory.add(HTMLCategoryBooks());
		inventory.add(SpringCategoryBooks());

	}

	private Map<String, List<Book>> JavaCategoryBooks() {

		Book thiningInJava = new Book("Thinking in Java", "1234567890", "Bruce Eckle", 1120, 789.90);
		Book completeReference = new Book("Complete Rreference Java", "1234567891", "Herbert Schildt", 126, 789.90);
		Book quickJava = new Book("Quick Java", "1234567892", "Spencer Bharath", 120, 789.90);
		Book java8Basics = new Book("Java 8 Basics", "1234567893", "Nitish Bharath", 420, 789.90);

		javaBooks.add(thiningInJava);
		javaBooks.add(completeReference);
		javaBooks.add(quickJava);
		javaBooks.add(java8Basics);

		Map<String, List<Book>> javaCollections = new HashMap<String, List<Book>>();
		javaCollections.put("Java", javaBooks);

		return javaCollections;
	}

	private Map<String, List<Book>> sqlCategoryBooks() {

		Book introToSql = new Book("Introducing Microsoft SQL Server 2014 (2014)", "sql4567890", "Ross Mistry", 1120,
				789.90);
		Book MicrosoftSQLServer = new Book("Microsoft SQL Server 2012 Internals (2013)", "sql67891", "Kalen Delaney",
				126, 789.90);
		Book SQLServer2012 = new Book("SQL Server 2012 Query Performance Tuning", "12345sql", "Wayne Sheffield", 120,
				789.90);
		Book SQLServer2012TSQLRecipes = new Book("SQL Server 2012 T-SQL Recipes, 3rd Edition (2012)", "sqlpp4567",
				"Wayne Sheffield", 420, 789.90);

		sqlBooks.add(introToSql);
		sqlBooks.add(MicrosoftSQLServer);
		sqlBooks.add(SQLServer2012);
		sqlBooks.add(SQLServer2012TSQLRecipes);

		Map<String, List<Book>> javaCollections = new HashMap<String, List<Book>>();
		javaCollections.put("sql", sqlBooks);

		return javaCollections;
	}

	private Map<String, List<Book>> HTMLCategoryBooks() {

		Book DesignandBuildWebsites = new Book("Design and Build Websites", "HTML4567890", "Jon Duckett", 1120,
				1789.90);
		Book ThinkinginHTMLeBook = new Book("Thinking in HTML eBook", "HTML67891", "Aravind Shenoy", 126, 789.90);
		Book TheSimplifiedBeginnersGuideToHTML = new Book("The Simplified Beginner's Guide To HTML", "12345HTML",
				"ClydeBank Technology", 1120, 1789.90);
		Book LearnHTMLandCSSfaster = new Book("Learn HTML and CSS faster", "HTMLpp4567", "Mark Myers", 4120, 1789.90);

		HTMLBooks.add(DesignandBuildWebsites);
		HTMLBooks.add(ThinkinginHTMLeBook);
		HTMLBooks.add(TheSimplifiedBeginnersGuideToHTML);
		HTMLBooks.add(LearnHTMLandCSSfaster);

		Map<String, List<Book>> javaCollections = new HashMap<String, List<Book>>();
		javaCollections.put("HTML", HTMLBooks);

		return javaCollections;
	}

	private Map<String, List<Book>> SpringCategoryBooks() {

		Book SpringMVC = new Book("Spring MVC: Beginner's Guide", "SPR4567890", "Amuthan G", 2120, 1089.90);
		Book GettingstartedwithSpringFramework = new Book("Getting started with Spring Framework ", "SPR67891",
				"J. Sharma", 126, 789.90);
		Book SpringinAction = new Book("Spring in Action (3rd Edition)", "12345SPR", "Craig Walls", 1120, 189.90);
		Book SpringinPractice = new Book("Spring in Practice", "SPR334567", "Joshua White", 4120, 1789.90);

		SpringBooks.add(SpringMVC);
		SpringBooks.add(GettingstartedwithSpringFramework);
		SpringBooks.add(SpringinAction);
		SpringBooks.add(SpringinPractice);

		Map<String, List<Book>> javaCollections = new HashMap<String, List<Book>>();
		javaCollections.put("spring", SpringBooks);

		return javaCollections;
	}

	@Override
	public void add(String category, Book book) {
		List<Book> books = null;
		Map<String, List<Book>> availableCategory = null;
		int categoryPosition = 0;

		getAllCategoriesFromInventory();

		if (category != null) {
			if (categories.contains(category)) {
				Iterator<Map<String, List<Book>>> itr = inventory.iterator();
				while (itr.hasNext()) {
					categoryPosition++;
					Map<String, List<Book>> categoryWiseBook = itr.next();
					if (categoryWiseBook.get(category) != null) {
						availableCategory = categoryWiseBook;
						books = categoryWiseBook.get(category);
						break;
					}
				}
			}
			books.add(book);
			availableCategory.replace(category, books);
			inventory.add(categoryPosition, availableCategory);
		}
	}

	public void getInventory() {

		getAllCategoriesFromInventory();
		for (String category : categories) {
			Iterator<Map<String, List<Book>>> itr = inventory.iterator();
			while (itr.hasNext()) {
				Map<String, List<Book>> categoryWiseBook = itr.next();
				if (categoryWiseBook.get(category) != null) {
					System.out.println(
							"Books in the category : " + category + " are : " + categoryWiseBook.get(category));
					break;
				}
			}

		}
	}

	private Set<String> getAllCategoriesFromInventory() {

		for (Map<String, List<Book>> categoryWiseBook : inventory) {
			Set<String> keys = categoryWiseBook.keySet();
			categories.addAll(keys);
		}
		return categories;
	}

	public void listBookCatogories() {

		System.out.println("java books press-1");
		System.out.println("sql books press-2");
		System.out.println("HTML books press-3");
		System.out.println("Spring books press-4");
		System.out.println("enter the book catogory");
		int GetCatagory = getbook.nextInt();
		if (GetCatagory == 1) {
			for (Book books : javaBooks)
				System.out.println(books);

		} else if (GetCatagory == 2) {
			for (Book books : sqlBooks)
				System.out.println(books);
		} else if (GetCatagory == 3) {
			for (Book books : HTMLBooks)
				System.out.println(books);
		} else if (GetCatagory == 4) {
			for (Book books : SpringBooks)
				System.out.println(books);
		}
		System.out.println("Search by 1)ISBN 2)TITLE 3)Author");
		System.out.println("enter the search method");
		String getInput = getbook.next();
		if (GetCatagory == 1 && getInput.equalsIgnoreCase("isbn")) {
			System.out.println("Enter the book ISBN to be searched");
			String getISBN = getbook.next();
			boolean result = false;

			for (Book book : javaBooks) {

				if (book.getIsbn().equalsIgnoreCase(getISBN)) {
					result = true;
					System.out.println("the book is avalible");
					System.out.println("the book name is " + book.getTitle() + "the book price is" + book.getPrice()
							+ "the number of pages in books are" + book.getNoOfPages()
							+ "the book is written by the author " + book.getAuthor());
					break;
				} else {
					result = false;
				}

			}
			if (result == false) {
				System.out.println("the book is not avalible");

			}

		}
		if (GetCatagory == 1 && getInput.equalsIgnoreCase("title")) {
			// Scanner sc = new Scanner(System.in);
			System.out.println("Enter the  Book Tittle to be searched");
			getbook = new Scanner(System.in);
			String getTitleofBook = getbook.nextLine();
			boolean getResultForBookTittle = false;

			for (Book book : javaBooks) {

				if (book.getTitle().equalsIgnoreCase(getTitleofBook)) {
					getResultForBookTittle = true;
					System.out.println("the book is avalible");
					System.out.println("the book name is " + book.getTitle() + "the book price is" + book.getPrice()
							+ "the number of pages in books are" + book.getNoOfPages()
							+ "the book is written by the author " + book.getAuthor());

					break;
				} else {
					getResultForBookTittle = false;
				}

			}
			if (getResultForBookTittle == false) {
				System.out.println("the book is not avalible");

			}
		}
		if (GetCatagory == 1 && getInput.equalsIgnoreCase("author")) {
			boolean getResultForBookTittle1 = false;
			System.out.println("Enter the book Book Author to be searched");
			getbook = new Scanner(System.in);
			String getAuthor = getbook.nextLine();

			for (Book book : javaBooks) {

				if (book.getAuthor().equalsIgnoreCase(getAuthor)) {
					getResultForBookTittle1 = true;
					System.out.println("the book with this title is avalible");
					System.out.println("the book name is " + book.getTitle() + "the book price is" + book.getPrice()
							+ "the number of pages in books are" + book.getNoOfPages()
							+ "the book is written by the author " + book.getAuthor());
					break;
				} else {
					getResultForBookTittle1 = false;
				}

			}
			if (getResultForBookTittle1 == false) {
				System.out.println("the book with this title is not avalible");
			}
		}
		if (GetCatagory == 2 && getInput.equalsIgnoreCase("isbn")) {
			boolean result = false;

			System.out.println("Enter the book ISBN to be searched");
			getbook = new Scanner(System.in);
			String getISBNofBook = getbook.nextLine();
			System.out.println(getISBNofBook);
			for (Book sqlBook : sqlBooks) {

				if (sqlBook.getIsbn().equalsIgnoreCase(getISBNofBook)) {
					result = true;
					System.out.println("the book is avalible");
					System.out.println("the book name is " + sqlBook.getTitle() + "the book price is"
							+ sqlBook.getPrice() + "the number of pages in books are" + sqlBook.getNoOfPages()
							+ "the book is written by the author " + sqlBook.getAuthor());
					break;
				} else {
					result = false;
				}

			}
			if (result == false) {
				System.out.println("the book is not avalible");

			}

		}
		if (GetCatagory == 2 && getInput.equalsIgnoreCase("title")) {
			// Scanner sc = new Scanner(System.in);
			System.out.println("Enter the  Book Tittle to be searched");
			getbook = new Scanner(System.in);
			String getTitleofBook = getbook.nextLine();
			boolean getResultForBookTittle = false;

			for (Book sqlbook : sqlBooks) {

				if (sqlbook.getTitle().equalsIgnoreCase(getTitleofBook)) {
					getResultForBookTittle = true;
					System.out.println("the book is avalible");
					System.out.println("the book name is " + sqlbook.getTitle() + "the book price is"
							+ sqlbook.getPrice() + "the number of pages in books are" + sqlbook.getNoOfPages()
							+ "the book is written by the author " + sqlbook.getAuthor());

					break;
				} else {
					getResultForBookTittle = false;
				}

			}
			if (getResultForBookTittle == false) {
				System.out.println("the book is not avalible");

			}
		}
		if (GetCatagory == 2 && getInput.equalsIgnoreCase("author")) {
			boolean getResultForBookTittle1 = false;
			System.out.println("Enter the book Book Author to be searched");
			getbook = new Scanner(System.in);
			String getAuthor = getbook.nextLine();

			for (Book sqlbook : sqlBooks) {

				if (sqlbook.getAuthor().equalsIgnoreCase(getAuthor)) {
					getResultForBookTittle1 = true;
					System.out.println("the book with this author is avalible");
					System.out.println("the book name is " + sqlbook.getTitle() + "the book price is"
							+ sqlbook.getPrice() + "the number of pages in books are" + sqlbook.getNoOfPages()
							+ "the book is written by the author " + sqlbook.getAuthor());
					break;
				} else {
					getResultForBookTittle1 = false;
				}

			}
			if (getResultForBookTittle1 == false) {
				System.out.println("the book with this author is not avalible");
			}
		}
		if (GetCatagory == 3 && getInput.equalsIgnoreCase("isbn")) {
			boolean result = false;

			System.out.println("Enter the book ISBN to be searched");
			getbook = new Scanner(System.in);
			String getISBNofBook = getbook.nextLine();
			System.out.println(getISBNofBook);
			for (Book htmlBook : HTMLBooks) {

				if (htmlBook.getIsbn().equalsIgnoreCase(getISBNofBook)) {
					result = true;
					System.out.println("the book is avalible");
					System.out.println("the book name is " + htmlBook.getTitle() + "the book price is"
							+ htmlBook.getPrice() + "the number of pages in books are" + htmlBook.getNoOfPages()
							+ "the book is written by the author " + htmlBook.getAuthor());
					break;
				} else {
					result = false;
				}

			}
			if (result == false) {
				System.out.println("the book is not avalible");

			}

		}
		if (GetCatagory == 3 && getInput.equalsIgnoreCase("title")) {
			boolean result = false;

			System.out.println("Enter the book title to be searched");
			getbook = new Scanner(System.in);
			String getTitleofBook = getbook.nextLine();
			System.out.println(getTitleofBook);
			for (Book htmlBook : HTMLBooks) {

				if (htmlBook.getTitle().equalsIgnoreCase(getTitleofBook)) {
					result = true;
					System.out.println("the book is avalible");
					System.out.println("the book name is " + htmlBook.getTitle() + "the book price is"
							+ htmlBook.getPrice() + "the number of pages in books are" + htmlBook.getNoOfPages()
							+ "the book is written by the author " + htmlBook.getAuthor());
					break;
				} else {
					result = false;
				}

			}
			if (result == false) {
				System.out.println("the book is not avalible");

			}
		}
		if (GetCatagory == 3 && getInput.equalsIgnoreCase("author")) {
			boolean getResultForBookTittle1 = false;
			System.out.println("Enter the book Book Author to be searched");
			getbook = new Scanner(System.in);
			String getAuthor = getbook.nextLine();

			for (Book htmlBook : HTMLBooks) {

				if (htmlBook.getAuthor().equalsIgnoreCase(getAuthor)) {
					getResultForBookTittle1 = true;
					System.out.println("the book with this author is avalible");
					System.out.println("the book name is " + htmlBook.getTitle() + "the book price is"
							+ htmlBook.getPrice() + "the number of pages in books are" + htmlBook.getNoOfPages()
							+ "the book is written by the author " + htmlBook.getAuthor());
					break;
				} else {
					getResultForBookTittle1 = false;
				}

			}
			if (getResultForBookTittle1 == false) {
				System.out.println("the book with this author is not avalible");
			}
		}
		if (GetCatagory == 4 && getInput.equalsIgnoreCase("isbn")) {
			boolean result = false;

			System.out.println("Enter the book ISBN to be searched");
			getbook = new Scanner(System.in);
			String getISBNofBook = getbook.nextLine();
			System.out.println(getISBNofBook);
			for (Book springBook : SpringBooks) {

				if (springBook.getIsbn().equalsIgnoreCase(getISBNofBook)) {
					result = true;
					System.out.println("the book is avalible");
					System.out.println("the book name is " + springBook.getTitle() + "the book price is"
							+ springBook.getPrice() + "the number of pages in books are" + springBook.getNoOfPages()
							+ "the book is written by the author " + springBook.getAuthor());
					break;
				} else {
					result = false;
				}

			}
			if (result == false) {
				System.out.println("the book is not avalible");

			}

		}
		if (GetCatagory == 4 && getInput.equalsIgnoreCase("title")) {
			boolean result = false;

			System.out.println("Enter the book title to be searched");
			getbook = new Scanner(System.in);
			String getTitleofBook = getbook.nextLine();
			System.out.println(getTitleofBook);
			for (Book springBook : SpringBooks) {

				if (springBook.getTitle().equalsIgnoreCase(getTitleofBook)) {
					result = true;
					System.out.println("the book is avalible");
					System.out.println("the book name is " + springBook.getTitle() + "the book price is"
							+ springBook.getPrice() + "the number of pages in books are" + springBook.getNoOfPages()
							+ "the book is written by the author " + springBook.getAuthor());
					break;
				} else {
					result = false;
				}

			}
			if (result == false) {
				System.out.println("the book is not avalible");

			}
		}
		if (GetCatagory == 4 && getInput.equalsIgnoreCase("author")) {
			boolean getResultForBookTittle1 = false;
			System.out.println("Enter the book Book Author to be searched");
			getbook = new Scanner(System.in);
			String getAuthor = getbook.nextLine();

			for (Book springBook : SpringBooks) {

				if (springBook.getAuthor().equalsIgnoreCase(getAuthor)) {
					getResultForBookTittle1 = true;
					System.out.println("the book with this author is avalible");
					System.out.println("the book name is " + springBook.getTitle() + "the book price is"
							+ springBook.getPrice() + "the number of pages in books are" + springBook.getNoOfPages()
							+ "the book is written by the author " + springBook.getAuthor());
					break;
				} else {
					getResultForBookTittle1 = false;
				}

			}
			if (getResultForBookTittle1 == false) {
				System.out.println("the book with this author is not avalible");
			}
		}
		if(GetCatagory>=5) {
			System.out.println();
		}
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------");
listBookCatogories();
	}
	

}