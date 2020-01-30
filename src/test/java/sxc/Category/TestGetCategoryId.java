package sxc.Category;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import sxc.util.Logger;

public class TestGetCategoryId {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine().toUpperCase();
		Logger logger = Logger.getInstance();

		CategoryDAOImplementation obj = new CategoryDAOImplementation();
		int id = obj.getFeeCategoryId(name);
		logger.info("Category ID: " + id);

	}

}
