package kr.co.goodee39.date1110;

public class Ex06Annotation {
	@AnnotationExample1(value="abc", bbb=7)
	String value1;
	@AnnotationExample1(value="bbc")
	String value2;
	@AnnotationExample1("ccc")
	String value3;
}
