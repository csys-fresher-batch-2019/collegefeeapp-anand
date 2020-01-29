package sxc.Category;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class TestGetCategoryId {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine().toUpperCase();

		CategoryDAOImplementation obj = new CategoryDAOImplementation();
		int id = obj.getFeeCategoryId(name);
		System.out.println("Category ID: " + id);
	
	}

}
