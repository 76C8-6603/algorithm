package main.com.ming.sort;

import java.util.Arrays;

/**
 * @author tianshiming
 */
public class MergeSort implements Sort{

    public static final int THRESHOLD_INSERT_SORT = 7;

    @Override
    public void sort(int[] rawArray) {
        if (rawArray.length == 0) {
            return;
        }
        int[] tempArray = new int[rawArray.length];
        mergeSort(rawArray, 0, rawArray.length - 1, tempArray);
    }

    private void mergeSort(int[] rawArray, int leftIndex, int rightIndex, int[] tempArray) {
        if (rightIndex - leftIndex + 1 <= THRESHOLD_INSERT_SORT) {
            insertionSort(rawArray, leftIndex, rightIndex);
            return;
        }

        int mid = (leftIndex + rightIndex) >>> 1;

        mergeSort(rawArray, leftIndex, mid, tempArray);
        mergeSort(rawArray, mid + 1, rightIndex, tempArray);

        if (rawArray[mid] <= rawArray[mid + 1]) {
            return;
        }

        mergeSortedArray(rawArray, leftIndex, mid, rightIndex, tempArray);
    }

    private void mergeSortedArray(int[] rawArray, int leftIndex, int mid, int rightIndex, int[] tempArray) {
         System.arraycopy(rawArray, leftIndex, tempArray, leftIndex, rightIndex - leftIndex + 1);

        int frontIndex = leftIndex;
        int behindIndex = mid + 1;

        int curIndex = 0;
        int curTemp;

        while (frontIndex <= mid || behindIndex <= rightIndex) {
            if (frontIndex == mid + 1) {
                curTemp = tempArray[behindIndex++];
            } else if (behindIndex == rightIndex + 1) {
                curTemp = tempArray[frontIndex++];
            } else if (tempArray[frontIndex] >= tempArray[behindIndex]) {
                curTemp = tempArray[behindIndex++];
            }else {
                curTemp = tempArray[frontIndex++];
            }
            rawArray[curIndex++] = curTemp;
        }
    }

    private void insertionSort(int[] rawArray, int leftIndex, int rightIndex) {
        for (int outer = leftIndex; outer <= rightIndex; outer++) {
            int inner = outer;
            int temp = rawArray[outer];
            while (inner > leftIndex  && rawArray[inner - 1] > temp) {
                rawArray[inner] = rawArray[inner - 1];
                inner--;
            }
            rawArray[inner] = temp;
        }
    }


    public static void main(String[] args) {
        final int[] ints = {9,3,8,13,5,4,10,7,1,2,22,6};
        final MergeSort mergeSort = new MergeSort();
        mergeSort.sort(ints);
        System.out.println(Arrays.toString(ints));
    }


}
