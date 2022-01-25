package kr.co.goodee39.date1118;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Ex08FileCopyChannel {

	public static void main(String[] args) throws Exception {
		Path from = Paths.get("C:/ABC/aaa.txt");
		Path to = Paths.get("C:/ABC/ddd.txt");
		
		FileChannel fcFrom = FileChannel.open(from, StandardOpenOption.READ);
		FileChannel fcTo = FileChannel.open(to, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
		
		ByteBuffer buffer = ByteBuffer.allocateDirect(100);
		int byteCount;
		
		while(true) {
			buffer.clear();
			byteCount = fcFrom.read(buffer);
			if(byteCount == -1)break;
			buffer.flip();
			fcTo.write(buffer);
		}
		
		fcFrom.close();
		fcTo.close();
		System.out.println("파일 복사 성공");
	}

}
