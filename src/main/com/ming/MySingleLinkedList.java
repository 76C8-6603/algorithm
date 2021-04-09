package main.com.ming;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * @author tianshiming
 */
public class MySingleLinkedList {
    public MySingleLinkedList next;
    public int value;

    public MySingleLinkedList(int value, MySingleLinkedList next) {
        this.next = next;
        this.value = value;
    }

    public MySingleLinkedList(int value) {
        this.value = value;
    }

    public MySingleLinkedList() {
    }

    @Override
    public String toString() {
        final ArrayList<String> strings = new ArrayList<>();
        for (MySingleLinkedList current = this; current != null; current = current.next) {
            strings.add(String.valueOf(current.value));
        }
        final String finalString = strings.stream().collect(Collectors.joining(","));
        return finalString;
    }
}
