package sxc.feeCourse;

public class FeeCourse {

	public static FeeCourse getInstance() {
		return new FeeCourse();
	}

	private int id;
	private int deptId;
	private int degId;
	private int amount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public int getDegId() {
		return degId;
	}

	public void setDegId(int degId) {
		this.degId = degId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}
