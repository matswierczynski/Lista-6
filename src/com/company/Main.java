package com.company;

public class Main {

    public static void main(String[] args) {
        final int size = LinkedList.collectSize();
	LinkedList<Integer> linlist1 = new LinkedList<>(size);
	LinkedList<Integer> linlist2 = new LinkedList<>(size);
	LinkedList<Integer> linlist3 = new LinkedList<>(linlist1,linlist2);
	//linlist1.show();
	linlist1.showFormatted();
	//linlist2.show();
	linlist2.showFormatted();
	//linlist3.show();
	linlist3.showFormatted();
    }
}
