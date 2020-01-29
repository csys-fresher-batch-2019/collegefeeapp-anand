package sxc.Category;

public interface CategoryInterface {

	void addFeeCategory(String name) throws Exception;
	int getFeeCategoryId(String name) throws Exception;
	String getFeeCategoryName(int id) throws Exception;
}
