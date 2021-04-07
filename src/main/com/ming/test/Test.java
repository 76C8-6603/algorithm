package main.com.ming.test;

import main.com.ming.MyLinkedList;

/**
 * @author 78c8-6603
 */
public class Test {
    public static void main(String[] args) {
        final MyLinkedList<Integer> myLinkedList = new MyLinkedList<>(1);
        myLinkedList.addAtHead(0);
        myLinkedList.addAtTail(2);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtTail(4);
        myLinkedList.addAtTail(5);
        System.out.println(myLinkedList);
        System.out.println(myLinkedList.index(5));

        myLinkedList.deleteAtIndex(3);
        System.out.println(myLinkedList);
        System.out.println(myLinkedList.index(5));

        myLinkedList.addAtIndex(3, 3);
        System.out.println(myLinkedList);
        System.out.println(myLinkedList.index(5));
        System.out.println(myLinkedList.get(5));
    }
}
