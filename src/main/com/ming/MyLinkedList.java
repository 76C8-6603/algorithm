package main.com.ming;

import org.w3c.dom.Node;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * @author 78c8-6603
 */
public class MyLinkedList<E> {
    private int size;
    private int modifySize;
    private Node<E> first;
    private Node<E> last;

    public MyLinkedList() {
    }

    public MyLinkedList(E val) {
        addAtHead(val);
    }

    public void addAtHead(E val) {
        Node<E> oldHeadNode = first;
        final Node<E> newHeadNode = new Node<>(null,val,oldHeadNode);
        first = newHeadNode;

        if (oldHeadNode == null) {
            last = newHeadNode;
        }else{
            oldHeadNode.prev = first;
        }
        size++;
        modifySize++;
    }

    public void addAtTail(E val) {
        final Node<E> oldTailNode = last;
        final Node<E> newTailNode = new Node<>(oldTailNode, val, null);
        last = newTailNode;

        if (oldTailNode == null) {
            first = newTailNode;
        }else{
            oldTailNode.next = newTailNode;
        }
        size++;
        modifySize++;

    }

    public void addAtIndex(E val, int index) {

        if (index > size || index < 0) {
            throw new IllegalArgumentException("No such index");
        }

        final Node<E> cur = get(index);
        if (index == size) {
            addAtTail(val);
        }else{
            addBefore(val,cur);
        }
    }

    public void addBefore(E val, Node<E> curNode) {
        final Node<E> pred = curNode.prev;
        final Node<E> newNode = new Node<>(pred, val, curNode);
        curNode.prev = newNode;
        if (pred == null) {
            first = newNode;
        }else{
            pred.next = newNode;
        }
        size++;
        modifySize++;
    }

    public Node<E> get(int i) {

        if (i > size - 1 || i < 0) {
            throw new IndexOutOfBoundsException();
        }

        return node(i);
    }

    public Node<E> node(int index) {
        if (index < (size >> 1)) {
            Node<E> startNode = first;
            for (int i = 0; i < index; i++) {
                startNode = startNode.next;
            }
            return startNode;
        }else{
            Node<E> lastNode = last;
            for (int i = size - 1; i > index; i--) {
                lastNode = lastNode.prev;
            }
            return lastNode;
        }

    }

    public E deleteAtIndex(int i) {

        if (i > size - 1 || i < 0 ) {
            throw new IndexOutOfBoundsException();
        }
        return unlink(node(i));
    }

    private E unlink(Node<E> node) {
        final E value = node.value;
        final Node<E> prev = node.prev;
        final Node<E> next = node.next;

        if (prev == null) {
            first = next;
        }else{
            prev.next = next;
            node.prev = null;
        }

        if (next == null) {
            last = prev;
        }else{
            next.prev = prev;
            node.next = null;
        }
        node.value = null;

        modifySize++;
        size--;

        return value;
    }

    public int index(Object obj) {
        if (size == 0) {
            throw new NullPointerException();
        }
        int index = 0;
        if (obj == null) {
            for (Node<E> cur = first; cur != null; cur = cur.next) {
                if (cur.value == null) {
                    return index;
                }
                index++;
            }
        }else{
            for (Node<E> cur = first; cur != null; cur = cur.next) {
                if (obj.equals(cur.value)) {
                    return index;
                }
                index++;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Node<E> cur = first; cur != null; cur = cur.next) {
            stringBuilder.append(cur).append(",");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    public class Node<E> {
        private Node<E> next;
        private Node<E> prev;
        private E value;

        public Node(E value) {
            this.value = value;
        }

        public Node(Node<E> prev, E value, Node<E> next) {
            this.next = next;
            this.prev = prev;
            this.value = value;
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value == null ? "null" : this.value.toString();
        }
    }

}
