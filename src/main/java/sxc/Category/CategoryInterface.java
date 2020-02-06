package sxc.Category;

import sxc.SXCException.DbException;

public interface CategoryInterface {

	void addFeeCategory(String name) throws DbException;
	int getFeeCategoryId(String name) throws DbException;
	String getFeeCategoryName(int id) throws DbException;
}
