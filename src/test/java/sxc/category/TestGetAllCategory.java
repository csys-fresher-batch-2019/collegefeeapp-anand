package sxc.category;

import java.util.ArrayList;
import sxc.util.Logger;

public class TestGetAllCategory {

	public static void main(String[] args) throws Exception {
		Logger logger = Logger.getInstance();
		CategoryDAOImplementation obj = CategoryDAOImplementation.getInstance();
		ArrayList<Category> list = obj.getAllCategory();
		logger.info(list);
	}
}
