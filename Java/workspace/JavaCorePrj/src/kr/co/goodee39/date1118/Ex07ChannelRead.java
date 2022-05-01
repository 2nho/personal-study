package kr.co.goodee39.date1118;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Path;

import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Ex07ChannelRead {

	public static void main(String[] args) throws Exception {
		Path path = Paths.get("C:/ABC/AAA/bbb.txt");
		
		FileChannel fc = FileChannel.open(path, StandardOpenOption.READ);
		ByteBuffer buffer = ByteBuffer.allocate(100);
		Charset cs = Charset.defaultCharset();
		String data = "";
		int byteCount;
		
		while(true) {
			byteCount = fc.read(buffer);
			if(byteCount == -1)break;
			buffer.flip();
			data += cs.decode(buffer).toString();
			buffer.clear();
		}
		
		fc.close();
		System.out.println("bbb.txt : "+data);
	}

}
