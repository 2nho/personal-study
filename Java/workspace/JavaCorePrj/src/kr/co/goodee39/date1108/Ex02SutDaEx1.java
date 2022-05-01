package kr.co.goodee39.date1108;

public class Ex02SutDaEx1 {

	public static void main(String[] args) {
		SutdaDeck deck = new SutdaDeck();
		
		System.out.println(deck.pick(0));
		System.out.println(deck.pick(1));
		deck.shuffle();
		
//		for (int i = 0; i < deck.cards.length; i++) {
//			System.out.print(deck.cards[i] + ",");
//		}
		
		for (int i = 0; i < deck.cards.size(); i++) {
			System.out.print(deck.cards.get(i) + ",");
		}
		
		System.out.println();
		System.out.println(deck.pick(0));
	}

}
