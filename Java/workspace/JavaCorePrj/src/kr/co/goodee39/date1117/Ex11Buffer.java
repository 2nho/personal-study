package kr.co.goodee39.date1117;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Ex11Buffer {
	public static void main(String[] args) {
		try {
			// Stream 방식
//			FileInputStream fis = new FileInputStream("D:/ABC/aaa.txt");
//			BufferedInputStream bis = new BufferedInputStream(fis);
//			int temp = 0;
//			while((temp=bis.read())!=-1) {
//				System.out.print((char)temp);
//			}
//			FileOutputStream fos = new FileOutputStream("D:/ABC/ccc.txt");
//			BufferedOutputStream bos = new BufferedOutputStream(fos);
//			byte[] b = new byte[1024];
//			bis.read(b);
//			bos.write(b);
//			
//			bis.close();
//			bos.close();
//			fis.close();
//			fos.close();
			
			// Reader/Writer 방식
//			FileReader fr = new FileReader("D:/ABC/aaa.txt");
//			BufferedReader br = new BufferedReader(fr);
//			
//			FileWriter fw = new FileWriter("D:/ABC/ddd.txt");
//			BufferedWriter bw = new BufferedWriter(fw);
//			
//			String s = "";
//			while((s = br.readLine())!=null) {
//				bw.write(s);
//			}
//			
//			br.close();
//			bw.close();
//			fr.close();
//			fw.close();
			
			// MIX
			FileInputStream fis = new FileInputStream("D:/ABC/aaa.txt");
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);
			
			FileOutputStream fos = new FileOutputStream("D:/ABC/eee.txt");
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			BufferedWriter bw = new BufferedWriter(osw);
			
			String s = "";
			while((s=br.readLine())!=null) {
				bw.write(s);
			}
			
			br.close();
			bw.close();
			isr.close();
			osw.close();
			fis.close();
			fos.close();

			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}











