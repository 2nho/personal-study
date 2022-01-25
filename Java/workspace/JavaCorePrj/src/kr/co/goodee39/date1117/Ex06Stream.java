package kr.co.goodee39.date1117;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Ex06Stream {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(90);
		list.add(80);
		list.add(70);
		
		double avg = list.stream().mapToInt(s -> s).average().getAsDouble();
		System.out.println(avg);
		
//		int[] arr1 = {1,2,3,4,5};
//		IntStream intStream = Arrays.stream(arr1);
		IntStream intStream = IntStream.rangeClosed(1, 50);
		intStream.forEach(a -> System.out.print(a + ","));
		System.out.println();
	}

}
