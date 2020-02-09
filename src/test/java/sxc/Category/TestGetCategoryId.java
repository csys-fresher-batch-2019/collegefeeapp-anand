package sxc.category;

import java.util.Scanner;

import sxc.util.Logger;

public class TestGetCategoryId {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine().toUpperCase();
		Logger logger = Logger.getInstance();

		Category c =new Category();
		c.setName(name);
		
		CategoryDAOImplementation obj = CategoryDAOImplementation.getInstance();
		int id = obj.getFeeCategoryId(c);
		logger.info("Category ID: " + id);

	}

}
