package main.com.ming.sort;

import java.util.Arrays;

/**
 * 合并两个有序数组
 * @author tianshiming
 * @date 2021/12/17
 */
public class CombineTwoSortedArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1;
        int index2 = n - 1;

        int index = m + n - 1;

        while (index2 >= 0) {
            if(index1 == -1 || nums2[index2] > nums1[index1]){
                nums1[index--] = nums2[index2--];
            }else {
                nums1[index--] = nums1[index1--];
            }
        }
    }


    public static void main(String[] args) {
        int[] array1 = new int[]{5, 8, 9, 0, 0, 0};
        int[] array2 = {3, 7, 10};
        CombineTwoSortedArray.merge(array1, 3, array2, 3);
        System.out.println(Arrays.toString(array1));

        int[] array3 = new int[]{5, 8, 9, 0, 0, 0};
        int[] array4 = {10, 12, 13};
        CombineTwoSortedArray.merge(array3, 3, array4, 3);
        System.out.println(Arrays.toString(array3));

        int[] array5 = new int[]{5, 8, 9, 0, 0, 0};
        int[] array6 = {1, 2, 3};
        CombineTwoSortedArray.merge(array5, 3, array6, 3);
        System.out.println(Arrays.toString(array5));


    }
}
