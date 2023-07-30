package com.jiquan.sortingAlgorithm;

import java.util.Arrays;

/**
 * @author ZHONG Jiquan
 * @create 29/07/2023 - 23:56
 */
public class InsertionSort {
  public static void main(String[] args) {
    int[] arr = new int[] {22, 34, 3, 32, 82, 55, 89, 50, 55, 37, 5, 64, 35, 9, 70};
    sort(arr);
    System.out.println(Arrays.toString(arr));
    System.out.println(verification(arr));
  }

  public static void sort(int[] nums) {
    // TODO implementation of sorting algorithm
    // 插入排序：从后向前扫描，前面都是已排序的，插入合适位置
    int len = nums.length;
    if (len == 1) return;

    for (int i = 1; i < len; i++) {
      int insertIndex = i - 1;
      int currentNum = nums[i];
      while (insertIndex >= 0 && currentNum < nums[insertIndex]) {
        nums[insertIndex + 1] = nums[insertIndex];
        insertIndex--;
      }
      nums[insertIndex + 1] = currentNum;
    }
  }

  private static void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  private static boolean verification(int[] nums) {
    if (nums.length == 1) return true;
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] > nums[i + 1]) return false;
    }
    return true;
  }
}
