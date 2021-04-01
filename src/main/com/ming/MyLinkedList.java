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

        if (size == 0 && index != 0) {
            throw new IllegalArgumentException("No such index");
        }
        if (index > size || index < 0) {
            throw new IllegalArgumentException("No such index");

        }

        final Node<E> cur = get(index);

        if (size == 0) {
            addAtHead(val);
        } else if (index == size) {
            addAtTail(val);
        }

        if (cur != null) {
            final Node<E> newNode = new Node<>(cur.prev, val, cur.next);
            final Node<E> curPrev = cur.prev;
            cur.prev = newNode;
            curPrev.next = newNode;
        }

    }

    public Node<E> get(int i) {
        if (size == 0) {
            throw null;
        }
        if (i > size - 1 || i < 0) {
            return null;
        }
        Node<E> targetNode = null;
        int index = 0;
        for (Node<E> curNode = first; curNode != null; curNode = curNode.next) {
            if (i == index) {
                targetNode = curNode;
                break;
            }
            index++;
        }
        return targetNode;
    }

    public void deleteAtIndex(int i) {
        if (size == 0) {
            throw new IllegalArgumentException();
        }
        if (i < 0 || i > size - 1) {
            throw new IllegalArgumentException();
        }
        int index = 0;
        for (Node<E> curNode = first; curNode != null; curNode = curNode.next) {
            if (i == index) {
                curNode.prev.next = curNode.next;
                curNode.next.prev = curNode.prev;
                modifySize++;
                size--;
                break;
            }
            index++;
        }
    }

    public int index(Object obj) {
        if (size == 0) {
            throw new IndexOutOfBoundsException();
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
