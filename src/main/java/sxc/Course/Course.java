package sxc.Course;

public class Course {

	int courseId;
	int deptId;
	int degreeId;
	int status;

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", deptId=" + deptId + ", degreeId=" + degreeId + ", status=" + status
				+ "]";
	}
	
}
