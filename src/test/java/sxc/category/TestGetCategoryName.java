package sxc.category;

import java.util.Scanner;

import sxc.util.Logger;

public class TestGetCategoryName {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		Logger logger = Logger.getInstance();
		int id = sc.nextInt();

		Category c = Category.getInstance();
		c.setId(id);

		CategoryDAOImplementation obj = CategoryDAOImplementation.getInstance();
		String name = obj.getFeeCategoryName(c);
		logger.info("Category Name: " + name);

	}

}
