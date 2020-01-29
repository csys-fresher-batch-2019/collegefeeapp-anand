package sxc.Category;

import java.util.Scanner;

public class TestGetCategoryName {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();

		CategoryDAOImplementation obj = new CategoryDAOImplementation();
		String name = obj.getFeeCategoryName(id);
		System.out.println("Category Name: " + name);

	}

}
