package com.company;

public class Main {

    public static void main(String[] args) {
	LinkedList<Integer> linlist1 = new LinkedList<>();
	linlist1.show();
	LinkedList<Integer> linlist2 = new LinkedList<>();
	linlist2.show();
	LinkedList<Integer> linlist3 = new LinkedList<>(linlist1);
	linlist3.show();
	linlist3.add(linlist2);
	linlist3.show();
    }
}
