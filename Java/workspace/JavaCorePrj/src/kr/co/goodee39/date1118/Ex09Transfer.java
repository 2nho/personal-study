package kr.co.goodee39.date1118;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public class Ex09Transfer {

	public static void main(String[] args) throws Exception{
		FileChannel fcFrom = new FileInputStream("C:/ABC/aaa.txt").getChannel();
		FileChannel fcTo = new FileOutputStream("C:/ABC/eee.txt").getChannel();
//		fcFrom.transferTo(0, fcFrom.size(), fcTo);
		fcTo.transferFrom(fcFrom, 0, fcFrom.size());
	}

}
