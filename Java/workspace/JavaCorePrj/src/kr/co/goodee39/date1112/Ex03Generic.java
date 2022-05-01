package kr.co.goodee39.date1112;

public class Ex03Generic {

	public static void main(String[] args) {
		Box<String> box1 = new Box<String>();
		box1.setT("hello");
		System.out.println(box1.getT());
		
		Box<Integer> box2 = new Box<Integer>();
		box2.setT(10);
		System.out.println(box2.getT());
		
		Product<String, Integer> product = new Product<String, Integer>();
		product.setType("A타입");
		product.setModel(1);
		
		System.out.println("타입 : "+product.getType());
		System.out.println("모델 : "+product.getModel());
		
		// Product<String> product1 = new Product<String>(); // error
		
		System.out.println("-------------------------------------------");
		Ex03Generic ex = new Ex03Generic();
		ex.printBox(box2);
	}
	
	public <T> Box<T> printBox(Box<T> box) {
		System.out.println(box.getT());
		return box;
	}
	
	public <T, M> Product<T, M> printProduct(Product<T,M> product){
		System.out.println(product.getType());
		System.out.println(product.getModel());
		return product;
	}
	
	public <T extends Number> int compare(T t1, T t2) {
		double v1 = t1.doubleValue();
		double v2 = t2.doubleValue();
		return Double.compare(v1, v2);
	}
	
}
