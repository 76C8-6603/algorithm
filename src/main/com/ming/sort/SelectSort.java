package main.com.ming.sort;

import java.util.Arrays;

/**
 * @author tianshiming
 */
public class SelectSort implements Sort{
    @Override
    public int[] sort(int[] rawArray) {
        for (int outer = 0; outer < rawArray.length; outer++) {
            int lowestIndex = outer;
            for (int inner = outer + 1; inner < rawArray.length; inner++) {
                if (rawArray[lowestIndex] > rawArray[inner]) {
                    lowestIndex = inner;
                }
            }
            if (lowestIndex != outer) {
                int temp = rawArray[outer];
                rawArray[outer] = rawArray[lowestIndex];
                rawArray[lowestIndex] = temp;
            }

        }
        return rawArray;
    }

    public static void main(String[] args) {
        final int[] ints = {0,3,5,4,0,3,4,2,2,6,8,8,1,6,2,7,0,5,6,6};
        System.out.println(Arrays.toString(ints));
        final SelectSort selectSort = new SelectSort();
        final int[] sorted = selectSort.sort(ints);
        System.out.println(Arrays.toString(sorted));
    }
}
