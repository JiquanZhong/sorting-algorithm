package com.jiquan.sortingAlgorithm;

import java.util.Arrays;

/**
 * @author ZHONG Jiquan
 * @create 29/07/2023 - 23:56
 */
public class BubbleSort {
  public static void main(String[] args) {
    int[] arr = new int[] {22, 34, 3, 32, 82, 55, 89, 50, 37, 5, 64, 35, 9, 70};
    sort(arr);
    System.out.println(Arrays.toString(arr));
    System.out.println(verification(arr));
  }

  private static void sort(int[] nums) {
    // TODO implementation of sorting algorithm
    // 冒泡算法：把大的元素"浮"上去
    int len = nums.length;
    if (len <= 1) {
      return;
    }
    for (int i = len - 2; i >= 0; i--) {
      // 比较j和j+1的大小
      for (int j = 0; j <= i; j++) {
        if (nums[j] > nums[j + 1]) {
          swap(nums, j, j + 1);
        }
      }
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
