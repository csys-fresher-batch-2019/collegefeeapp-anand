package sxc.Department;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class TestGetAllDepartments {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		DeptDAOImplementation obj=new DeptDAOImplementation();
		ArrayList<Department> listDept=obj.listAllDepartments();
		System.out.println(listDept);
		
		String fileContent="";
		
		for (Department department : listDept) {
			String line="\n DEPT NAME: "+department.deptName+"\n DEPT ID: "+department.deptId;
			fileContent=fileContent+line;
		}
		
		Path path=Paths.get("getalldepartments.txt");
		Files.write(path, fileContent.getBytes(), StandardOpenOption.TRUNCATE_EXISTING);
		
	}

}
