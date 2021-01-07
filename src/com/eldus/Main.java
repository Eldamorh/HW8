package com.eldus;

import java.util.*;


public class Main {

	public static Queue<String> turnOverV1(Queue<String> queue){

		String[] arr = new String[queue.size()];
		queue.toArray(arr);
		for (int i = 0; i < arr.length/2; i++) {
			String temp = arr[arr.length-i-1];
			arr[arr.length-i-1] = arr[i];
			arr[i] = temp;
		}
		return new ArrayDeque<>(Arrays.asList(arr));
	}
	public static Queue<String> turnOverV2(Queue<String> queue){
		Queue<String> newQueue = new ArrayDeque<>();
		Queue<String> temp = new ArrayDeque<>(queue);
		while(!temp.isEmpty()){
			newQueue.add(temp.remove());
		}
		return newQueue;
	}


	public static Queue<String> deleteOver4(Queue<String> queue){
		Queue<String> newQueue = new ArrayDeque<>();
		Queue<String> temp = new ArrayDeque<>(queue);
		while(!temp.isEmpty()){
			if(temp.element().length()>4){
				temp.remove();
			}
			else{
				newQueue.add(temp.remove());
			}
		}
		return newQueue;
	}

	public static Queue<String> dublicateDeleteWithoutSet(Queue<String> queue){
		Queue<String> newQueue = new ArrayDeque<>();
		Queue<String> temp = new ArrayDeque<>(queue);
		while(!temp.isEmpty()){
			if(newQueue.contains(temp.element())){
				temp.remove();
			}
			else{
				newQueue.add(temp.remove());
			}
		}
		return newQueue;
	}
	public static Queue<String> dublicateDeleteWithSet(Queue<String> queue){
		return new ArrayDeque<>(new HashSet<>(queue));
	}

    public static void main(String[] args) {
		Queue<String> queue = new ArrayDeque<>();
    	queue.offer("gav1");
    	queue.offer("gav3");
    	queue.offer("gav3");
    	queue.offer("gav4");
    	queue.offer("gav4");



//		Queue<String> queue1 = turnOver(queue);
//		System.out.println(Arrays.toString(queue.toArray()));
//		System.out.println(Arrays.toString(queue1.toArray()));
//		System.out.println("_____________________");
//
//
//
//
//
//
//		Queue<String> queue2 = turnOver2(queue);
//		System.out.println(Arrays.toString(queue.toArray()));
//		System.out.println(Arrays.toString(queue2.toArray()));
//		System.out.println("_____________________");
//
//
//
//		Queue<String> queue3 = deleteOver4(queue);
//		System.out.println(Arrays.toString(queue.toArray()));
//		System.out.println(Arrays.toString(queue3.toArray()));
//		System.out.println("_____________________");

		Queue<String> queue4 = dublicateDeleteWithoutSet(queue);
		System.out.println(Arrays.toString(queue.toArray()));
		System.out.println(Arrays.toString(queue4.toArray()));
		System.out.println("_____________________");


		Queue<String> queue5 = dublicateDeleteWithSet(queue);
		System.out.println(Arrays.toString(queue.toArray()));
		System.out.println(Arrays.toString(queue5.toArray()));







//		System.out.println(queue.remove());
//		System.out.println(queue.poll());
//		System.out.println(queue1.poll());
//		System.out.println(queue1.remove());


//	    StringLinkedList list = new StringLinkedListImpl("gav1");
//	    list.addFirst("gav2");
//	    list.addFirst("gav3");
//	    list.addFirst("gav4");
//	    list.addFirst("gav5");
//	    list.addFirst("gav6");
//	    list.addFirst("gav7");
//
//		System.out.println();
//
//
//		System.out.println(list.get(4));
//		System.out.println(list.get(4));
//		System.out.println(list.getLast());
//		System.out.println(list.getLast());
//		System.out.println(list.getLast());
//		System.out.println(list.getLast());
//		System.out.println(list.getLast());
//		System.out.println(list.getLast());



	}
}
