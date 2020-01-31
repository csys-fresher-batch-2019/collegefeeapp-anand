package sxc.Student;

public class Stud_Class {

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegno() {
		return regno;
	}

	public void setRegno(String regno) {
		this.regno = regno;
	}

	public int getStud_active() {
		return stud_active;
	}

	public void setStud_active(int stud_active) {
		this.stud_active = stud_active;
	}

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	private String name;
	private String regno;
	private int stud_active;
	private int course_id;

	@Override
	public String toString() {
		return "Stud_Class [name=" + name + ", regno=" + regno + ", stud_active=" + stud_active + ", course_id="
				+ course_id + "]";
	}
}
