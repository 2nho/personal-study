package kr.co.goodee39.date1117;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;

public class Ex09FileStream {
	public static void main(String[] args) {
		File file = new File("D:/ABC/aaa.txt");
		try {
//			FileInputStream fis = new FileInputStream(file);
//			int temp = 0;
//			while((temp = fis.read())!=-1) {
//				System.out.print((char)temp);
//			}
//			System.out.println();
			FileReader fr = new FileReader(file);
			int temp = 0;
			while((temp=fr.read())!=-1) {
				System.out.print((char)temp);
			}
			System.out.println();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
