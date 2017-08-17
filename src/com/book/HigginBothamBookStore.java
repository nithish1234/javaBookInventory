package com.book;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
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
	List<Book> selectedBooks;

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
		Book SQLServer2012TSQLRecipes = new Book("SQL Server 2012 T-SQL Recipes 3rd Edition (2012)", "sqlpp4567",
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

	public void getBookByISBN() {
		boolean getBookISBN = false;
		System.out.println("enter the ISBN");
		getbook = new Scanner(System.in);
		String getISBN = getbook.nextLine();
		for (Book book : selectedBooks) {

			if (book.getIsbn().equalsIgnoreCase(getISBN)) {
				getBookISBN = true;
				System.out.println("the book is avalible");
				System.out.println("the book name is " + book.getTitle() + "the book price is" + book.getPrice()
						+ "the number of pages in books are" + book.getNoOfPages()
						+ "the book is written by the author " + book.getAuthor());
				break;
			} else {
				getBookISBN = false;
			}

		}
		if (getBookISBN == false) {
			System.out.println("the book is not avalible");

		}
		
	}
	public void getInputFromUser() {
		
		System.out.println("java books press-1");
		System.out.println("sql books press-2");
		System.out.println("HTML books press-3");
		System.out.println("Spring books press-4");
		
			System.out.println("enter the book catogory");
			int GetCatagory = getbook.nextInt();
			listBookCatogories(GetCatagory);
	
		
	}

	public void getBookByTitle() {
		
		boolean getBookTitle = false;
		System.out.println("enter the Title");
		getbook = new Scanner(System.in);
		String getTitle = getbook.nextLine();
		for (Book book : selectedBooks) {

			if (book.getTitle().equalsIgnoreCase(getTitle)) {
				getBookTitle = true;
				System.out.println("the book is avalible");
				System.out.println("the book name is " + book.getTitle() + "the book price is" + book.getPrice()
						+ "the number of pages in books are" + book.getNoOfPages()
						+ "the book is written by the author " + book.getAuthor());
				break;
			} else {
				getBookTitle = false;
			}

		}
		if (getBookTitle == false) {
			System.out.println("the book is not avalible");

		}
	}

	public void getBookByAuthor() {
		System.out.println("enter the author name");
		getbook = new Scanner(System.in);
		String getAuthor = getbook.nextLine();

		boolean getResultForBookAuthor = false;

		for (Book book : selectedBooks) {

			if (book.getAuthor().equalsIgnoreCase(getAuthor)) {
				getResultForBookAuthor = true;
				System.out.println("the book is avalible");
				System.out.println("the book name is " + book.getTitle() + "the book price is" + book.getPrice()

						+ "the number of pages in books are" + book.getNoOfPages()
						+ "the book is written by the author " + book.getAuthor());

				break;
			} else {
				getResultForBookAuthor = false;
			}

		}
		if (getResultForBookAuthor == false) {
			System.out.println("the book is not avalible");

		}
	}

	public void listBookCatogories(int getBookByCatagory) {

		int GetCatagory = getBookByCatagory;
		switch (GetCatagory) {
		case 1:
			selectedBooks = javaBooks;
			for (Book books : javaBooks)
				System.out.println(books);

			break;
		case 2:
			selectedBooks = sqlBooks;
			for (Book books : sqlBooks)
				System.out.println(books);
			break;
		case 3:
			selectedBooks = HTMLBooks;
			for (Book books : HTMLBooks)
				System.out.println(books);
			break;
		case 4:
			selectedBooks = SpringBooks;
			for (Book books : SpringBooks)
				System.out.println(books);
			break;
			default:
				System.out.println("enter the correct code");
				getInputFromUser();
		}


	}

	public void getCatagories(int SearchBook) {
try {
		int getInput = SearchBook;

		switch (getInput) {
		case 1:
			getBookByISBN();
			break;
		case 2:
			getBookByTitle();
			break;
		case 3:
			getBookByAuthor();
			break;
default :
	System.err.println("no match found");
getInputFromUser();
listBookCatogories(getInput);
	break;
		}
	
}
catch (Exception e) {
	// TODO: handle exception
	System.err.println("Enter correct Input");
}
	}

}





