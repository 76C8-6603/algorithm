package main.com.ming.sort;

import java.util.Arrays;

/**
 * @author tianshiming
 */
public class InsertSort implements Sort{

    @Override
    public int[] sort(int[] rawArray) {
        for (int outer = 0; outer < rawArray.length; outer++) {
            int temp = rawArray[outer];
            int inner = outer-1;
            while (inner > 0 && rawArray[inner] > temp) {
                rawArray[inner + 1] = rawArray[inner];
                rawArray[inner] = temp;
                inner--;
            }

        }
        return rawArray;
    }

    public static void main(String[] args) {
        final int[] ints = {0,3,5,4,0,3,4,2,2,6,8,8,1,6,2,7,0,5,6,6};
        System.out.println(Arrays.toString(ints));
        final InsertSort insertSort = new InsertSort();
        final int[] sort = insertSort.sort(ints);
        System.out.println(Arrays.toString(sort));
    }
}
