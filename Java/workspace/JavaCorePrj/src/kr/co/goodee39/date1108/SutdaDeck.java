package kr.co.goodee39.date1108;

import java.util.ArrayList;

public class SutdaDeck {
	final int CARD_NUM = 20;
//	SutdaCard[] cards = new SutdaCard[CARD_NUM];
	ArrayList<SutdaCard> cards = new ArrayList<SutdaCard>();
	ArrayList<Integer> ints = new ArrayList<Integer>();
	
	public SutdaDeck() {
		for (int i = 0; i < CARD_NUM; i++) {
			int num = i % 10 + 1;
//			boolean isKwang = (i < 10)&&(num==1||num==3||num==8);
			boolean isKwang = (i==0||i==2||i==7);
			
//			cards[i] = new SutdaCard(num, isKwang);
			cards.add(new SutdaCard(num, isKwang));
		}
	}
	
	public void shuffle() {
		for (int i = 0; i < CARD_NUM; i++) {
			int j = (int)(Math.random()*CARD_NUM);
			
//			SutdaCard tmp = cards[i];
//			cards[i] = cards[j];
//			cards[j] = tmp;
			SutdaCard tmp = cards.get(i);
			cards.set(i, cards.get(j));
			cards.set(j, tmp);
		}
	}
	
	public SutdaCard pick(int index) {
		if(index < 0 || index >= CARD_NUM) return null;
//		return cards[index];
		return cards.get(index);
	}
	
	public SutdaCard pick() {
		int index = (int)(Math.random()*CARD_NUM);
		return pick(index);
	}
}
