package main.com.ming.test;

/**
 * @author 78c8-6603
 */
public class SimpleTest {
    public static void main(String[] args) {
        int a = 200;
        System.out.println(a);
        a = a << 2;
        System.out.println(a);
        a = a >> 1;
        System.out.println(a);
        a = a >>> 1;
        System.out.println(a);
        a = a << 10;
        System.out.println(a);
        int b = -32;
        System.out.println(b >>> 2);
    }
}
