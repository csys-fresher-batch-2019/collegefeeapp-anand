package sxc.Category;

import java.util.Scanner;

public class TestAddFeeCategory {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine().toUpperCase();

		CategoryDAOImplementation obj = new CategoryDAOImplementation();
		obj.addFeeCategory(name);

	}

}
