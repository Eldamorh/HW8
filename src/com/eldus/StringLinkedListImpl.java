package com.eldus;

class StringLinkedListImpl implements StringLinkedList {

    private Node first;
    private Node last;

    StringLinkedListImpl(String value) {
        first = new Node();
        first.setValue(value);
        first.setNext(null);
        first.setPrevious(null);
        last = first;
        last.setIndex(1);
        first.setIndex(last.getIndex());

    }

    @Override
    public void addFirst(String s) {
        Node temp = new Node();
        Node reader = first;
        while(reader.getNext()!=null)
        {
            reader.setIndex(reader.getIndex()+1);
            reader = reader.getNext();
        }
        first.setPrevious(temp);
        temp.setNext(first);
        temp.setValue(s);
        temp.setPrevious(null);
        temp.setIndex(1);
        first = temp;
        last.setIndex(last.getIndex()+1);;
    }

    @Override
    public void add(String s, int index) {
        if (index == 1) {
            addFirst(s);
        }
        if (index == last.getIndex()) {
            addLast(s);
        }
        Node reader = first;
        while (reader.getNext() != null) {

            if (index == reader.getNext().getIndex()) {
                Node temp = new Node(); //В этот момент я начинаю понимать что что то не так
                reader.getNext().setPrevious(temp);
                temp.setNext(reader.getNext());
                temp.setPrevious(reader);
                reader.setNext(temp);
                temp.setValue(s);
                temp.setIndex(index);
                reader = reader.getNext();
                while(reader.getNext() != null){
                    reader.getNext().setIndex(reader.getIndex()+1);
                    reader = reader.getNext();
                }
                break;
            }
            else{
                reader = reader.getNext();
            }
        }
    }

    public void getIndexes(){
        Node reader = first;
        while(reader.getNext()!=null){
            System.out.print(reader.getIndex()+" ");
            reader = reader.getNext();
        }
        System.out.print(last.getIndex());
    }

    @Override
    public void addLast(String s) {
        Node temp = new Node();
        last.setNext(temp);
        temp.setNext(null);
        temp.setPrevious(last);
        temp.setValue(s);
        temp.setIndex(last.getIndex()+1);
        last = temp;
    }

    @Override
    public String getFirst() {
        return first.getValue();
    }

    @Override
    public String get(int i) {
        if(last.getIndex() == i){
            return last.getValue();
        }
        Node reader = first;
        while(reader.getNext()!=null){
            if(reader.getNext().getIndex()==i){
                return reader.getNext().getValue();
            }
            else{
                reader = reader.getNext();
            }
        }
        return null;
    }

    @Override
    public String getLast() {
        return last.getValue();
    }

    @Override
    public String removeFirst() {
        if (first == null) {
            return null;
        }
        Node temp = first;
        while (temp.getNext() != null) {
            temp = temp.getNext();
            temp.setIndex(temp.getIndex() - 1);
        }
        temp = first;
        if (first.getNext() != null) {
            first = first.getNext();
            first.setPrevious(null);
            first.setIndex(1);
        } else {
            first = null;
            last = null;
        }
        return temp.getValue();
    }

    @Override
    public String remove(int i) {
        if (i == 1) {
            return first.getValue();
        }
        Node reader = first;
        while (reader.getNext() != null) {
            if (reader.getNext().getIndex() == i) {
                Node temp = reader.getNext();
                reader.setNext(temp.getNext());
                temp.getNext().setPrevious(reader);
                while(reader.getNext() != null){
                    reader = reader.getNext();
                    reader.setIndex(reader.getIndex()-1);
                }
                return temp.getValue();
            } else {
                reader = reader.getNext();
            }
        }
        return null;
    }

    @Override
    public String removeLast() {
        if (last == null) {
            return null;
        }
        Node temp = last;
        if (last.getPrevious() != null) {
            last = last.getPrevious();
            last.setNext(null);
        } else {
            first = null;
            last = null;
        }
        return temp.getValue();
    }

    @Override
    public int size() {
        return last.getIndex();
    }
}
