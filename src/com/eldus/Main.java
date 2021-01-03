package com.eldus;

public class Main {

    public static void main(String[] args) {
	    StringLinkedListImpl list = new StringLinkedListImpl("gav1");
	    list.addFirst("gav2");
	    list.addFirst("gav3");
	    list.addFirst("gav4");
	    list.addFirst("gav5");
	    list.addFirst("gav6");
	    list.addFirst("gav7");

	    list.getIndexes();
		System.out.println();


		System.out.println(list.get(4));
		System.out.println(list.get(4));
		System.out.println(list.getLast());
		System.out.println(list.getLast());
		System.out.println(list.getLast());
		System.out.println(list.getLast());
		System.out.println(list.getLast());
		System.out.println(list.getLast());



	}
}
