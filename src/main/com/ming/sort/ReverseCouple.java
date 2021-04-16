package main.com.ming.sort;

import java.util.Arrays;

/**
 * @author tianshiming
 */
public class ReverseCouple {
    public int reversePairs(int[] nums) {

        if (nums.length < 2) {
            return 0;
        }

        //不修改源数组
        int[] copy = new int[nums.length];
        System.arraycopy(nums, 0, copy, 0, nums.length);

        final int[] temp = new int[nums.length];

        return mergeSort(copy, 0, nums.length - 1, temp);
    }

    private int mergeSort(int[] nums, int start, int end, int[] temp) {
        if (start == end) {
            return 0;
        }

        int mid = (start + end) >>> 1;

        int leftCount = mergeSort(nums, start, mid, temp);
        int rightCount = mergeSort(nums, mid + 1, end, temp);

        if (nums[mid] <= nums[mid + 1]) {
             return leftCount + rightCount;
        }

        int mergeCount = mergeTwoSortedArr(nums, start, mid, end, temp);

        return leftCount + rightCount + mergeCount;
    }

    private int mergeTwoSortedArr(int[] nums, int start, int mid, int end, int[] temp) {
        System.arraycopy(nums, start, temp, start, end - start + 1);

        int frontIndex = start;
        int behindIndex = mid + 1;
        int curTemp = 0;

        int mergeCount = 0;

        for (int i = frontIndex; i <= end; i++) {
            if (frontIndex == mid + 1) {
                curTemp = temp[behindIndex++];
            } else if (behindIndex == end + 1) {
                curTemp = temp[frontIndex++];
            } else if (temp[frontIndex] <= temp[behindIndex]) {
                curTemp = temp[frontIndex++];
            }else {
                curTemp = temp[behindIndex++];
                mergeCount += (mid - frontIndex + 1);
            }
            nums[i] = curTemp;
        }
        return mergeCount;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,2,3,1};
        final ReverseCouple reverseCouple = new ReverseCouple();
        final int totalReversePairs = reverseCouple.reversePairs(nums);
        System.out.println(totalReversePairs);
        System.out.println(Arrays.toString(nums));
    }
}
