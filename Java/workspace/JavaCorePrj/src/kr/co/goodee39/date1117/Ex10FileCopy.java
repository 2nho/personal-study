package kr.co.goodee39.date1117;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;


public class Ex10FileCopy {

	public static void main(String[] args) {
		try {
//			FileInputStream fis = new FileInputStream("D:/ABC/aaa.txt");
//			FileOutputStream fos = new FileOutputStream("D:/ABC/bbb.txt");
//			byte[] b = new byte[1024];
//			fis.read(b);
//			fos.write(b);
//			fis.close();
//			fos.close();
			FileReader fr = new FileReader("D:/ABC/aaa.txt");
			FileWriter fw = new FileWriter("D:/ABC/bbb.txt");
			char[] c = new char[1024];
			fr.read(c);
			fw.write(c);
			fr.close();
			fw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
