package main.com.ming.sort;

import main.com.ming.MyLinkedList;
import main.com.ming.MySingleLinkedList;

import java.util.Arrays;

/**
 * @author tianshiming
 */
public class InsertSort implements Sort{

    @Override
    public void sort(int[] rawArray) {
        for (int outer = 0; outer < rawArray.length; outer++) {
            int temp = rawArray[outer];
            int inner = outer;
            while (inner > 0 && rawArray[inner-1] > temp) {
                rawArray[inner] = rawArray[inner-1];
                inner--;
            }
            rawArray[inner] = temp;

        }
    }

    /**
     * 单链表插入排序
     * @param head
     * @return
     */
    public MySingleLinkedList sort(MySingleLinkedList head) {
        MySingleLinkedList mockHead = new MySingleLinkedList(0, head);
        MySingleLinkedList lastSorted = head;
        for (MySingleLinkedList cur = head.next; cur != null; cur = cur.next) {
            if (cur.value > lastSorted.value) {
                lastSorted = cur;
            }else{
                MySingleLinkedList prev = mockHead;
                while(cur.value > prev.next.value){
                    prev = prev.next;
                }
                final MySingleLinkedList prevNext = prev.next;
                final MySingleLinkedList curNext = cur.next;
                cur.next = prevNext;
                prev.next = cur;
                lastSorted.next = curNext;
            }
            cur = lastSorted;
        }
        return mockHead.next;

    }

    public static void main(String[] args) {
        final int[] ints = {0,3,5,4,0,3,4,2,2,6,8,8,1,6,2,7,0,5,6,6};
        System.out.println(Arrays.toString(ints));
        final InsertSort insertSort = new InsertSort();
        insertSort.sort(ints);
        System.out.println(Arrays.toString(ints));

        final MySingleLinkedList mySingleLinkedList = new MySingleLinkedList(5);
        mySingleLinkedList.next = new MySingleLinkedList(3);
        mySingleLinkedList.next.next = new MySingleLinkedList(9);
        mySingleLinkedList.next.next.next = new MySingleLinkedList(1);
        mySingleLinkedList.next.next.next.next = new MySingleLinkedList(2);
        System.out.println(mySingleLinkedList);
        final MySingleLinkedList linkedList = insertSort.sort(mySingleLinkedList);
        System.out.println(linkedList);
    }
}
