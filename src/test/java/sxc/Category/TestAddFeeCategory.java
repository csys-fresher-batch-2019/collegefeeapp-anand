package sxc.category;

import java.util.Scanner;

public class TestAddFeeCategory {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine().toUpperCase();

		Category c = new Category();
		c.setName(name);
		
		CategoryDAOImplementation obj = CategoryDAOImplementation.getInstance();
		obj.addFeeCategory(c);

	}

}
