package main.com.ming.sort;

import java.util.Arrays;

/**
 * @author tianshiming
 */
public class MergeSort implements Sort{

    public static final int THRESHOLD_INSERT_SORT = 7;

    @Override
    public int[] sort(int[] rawArray) {
        int[] tempArray = new int[rawArray.length];
        mergeSort(0, rawArray.length - 1, rawArray, tempArray);
        return rawArray;
    }

    private void mergeSort(int startIndex, int endIndex, int[] rawArray, int[] tempArray) {
        if (endIndex - startIndex + 1  <= THRESHOLD_INSERT_SORT) {
            insertSort(rawArray, startIndex, endIndex);
            return;
        }

        int mid = (startIndex + endIndex) >>> 1;

        mergeSort(startIndex, mid, rawArray, tempArray);
        mergeSort(mid + 1, endIndex, rawArray, tempArray);

        if (rawArray[mid] <= rawArray[mid + 1]) {
            return;
        }
        mergeSorted(startIndex, mid, endIndex, rawArray, tempArray);

    }

    private void mergeSorted(int startIndex, int mid, int endIndex, int[] rawArray, int[] tempArray) {
        System.arraycopy(rawArray, startIndex, tempArray, startIndex, endIndex - startIndex + 1);
        int frontIndex = startIndex;
        int behindIndex = mid + 1;

        int curIndex = startIndex;
        int tempCur = 0;
        while (frontIndex <= mid - 1 || behindIndex <= endIndex) {
            if (frontIndex == mid+1) {
                tempCur = tempArray[behindIndex++];
            } else if (behindIndex == endIndex + 1) {
                tempCur = tempArray[frontIndex++];
            } else if (tempArray[behindIndex] >= tempArray[frontIndex]) {
                tempCur = tempArray[frontIndex++];
            }else{
                tempCur = tempArray[behindIndex++];
            }
            rawArray[curIndex++] = tempCur;
        }
    }

    private void insertSort(int[] rawArray, int startIndex, int endIndex) {
        for (int outer = startIndex + 1; outer <= endIndex; outer++) {

            int temp = rawArray[outer];
            int inner = outer;
            while (inner > startIndex && temp < rawArray[inner - 1]) {
                rawArray[inner] = rawArray[inner - 1];
                inner--;
            }
            if (inner != outer) {
                rawArray[inner] = temp;
            }
        }
    }

    public static void main(String[] args) {
        final int[] ints = {9,3,8,5,4,7,1,2,6};
        final MergeSort mergeSort = new MergeSort();
        mergeSort.sort(ints);
        System.out.println(Arrays.toString(ints));
    }


}
