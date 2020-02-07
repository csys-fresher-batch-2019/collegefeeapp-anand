package sxc.Category;

public interface CategoryInterface {

	void addFeeCategory(Category c) throws Exception;
	int getFeeCategoryId(Category c) throws Exception;
	String getFeeCategoryName(Category c) throws Exception;
}
