package sxc.category;

import sxc.util.Logger;

import java.util.Scanner;

public class TestGetCategoryId {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine().toUpperCase();
		Logger logger = Logger.getInstance();

		Category c = Category.getInstance();
		c.setName(name);

		CategoryDAOImplementation obj = CategoryDAOImplementation.getInstance();
		int id = obj.getFeeCategoryId(c);
		logger.info("Category ID: " + id);
		sc.close();
	}

}
