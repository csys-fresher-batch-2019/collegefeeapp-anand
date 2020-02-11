package sxc.department;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

import sxc.util.Logger;

public class TestGetAllDepartments {

	public static void main(String[] args) throws Exception {

		Logger logger = Logger.getInstance();
		DeptDAOImplementation obj = DeptDAOImplementation.getInstance();
		ArrayList<String> listDept = obj.listAllDepartments();
		logger.info(listDept.toString());

		String fileContent = "";

		for (String department : listDept) {
			String line = "DEPT NAME: " + department + "\n";
			fileContent = fileContent + line;
		}

		Path path = Paths.get("getalldepartments.txt");
		Files.write(path, fileContent.getBytes(), StandardOpenOption.TRUNCATE_EXISTING);

	}

}
