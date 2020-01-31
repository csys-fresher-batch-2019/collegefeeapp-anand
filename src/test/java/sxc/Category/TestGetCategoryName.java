package sxc.Category;

import java.util.Scanner;

import sxc.util.Logger;

public class TestGetCategoryName {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Logger logger=Logger.getInstance();
		int id = sc.nextInt();

		CategoryDAOImplementation obj = CategoryDAOImplementation.getInstance();
		String name = obj.getFeeCategoryName(id);
		logger.info("Category Name: " + name);

	}

}
