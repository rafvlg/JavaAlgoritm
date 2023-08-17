package Seminar3;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addFirst(1);
        list.addFirst(2);
//        list.print();
        list.addFirst(3);
        list.addFirst(4);
//        list.print();
        list.addLast(8);
        list.addLast(5);
        list.print();
        list.deleteFirst();
//        list.print();
        list.deleteLast();
//        list.print();

    }
}
