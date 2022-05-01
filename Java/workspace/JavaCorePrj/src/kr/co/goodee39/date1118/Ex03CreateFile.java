package kr.co.goodee39.date1118;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ex03CreateFile {

	public static void main(String[] args) throws Exception {
		Path path1 = Paths.get("C:/ABC/AAA");
		Path path2 = Paths.get("C:/ABC/AAA/bbb.txt");
		
		Path path3 = Paths.get("C:/ABC/aaa.txt");
		Path path4 = Paths.get("C:/ABC/AAA/ccc.txt");
		
		if(Files.notExists(path1))Files.createDirectories(path1);
		if(Files.notExists(path2))Files.createFile(path2);
//		if(Files.notExists(path4))Files.copy(path3, path4);
		if(Files.exists(path4))Files.delete(path4);
		
	}

}
