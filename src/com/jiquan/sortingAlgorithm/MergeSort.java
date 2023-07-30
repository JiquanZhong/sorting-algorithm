package com.jiquan.sortingAlgorithm;

import java.util.Arrays;

/**
 * @author ZHONG Jiquan
 * @create 29/07/2023 - 23:56
 */
public class MergeSort {
  public static void main(String[] args) {
    int[] arr = new int[] {22, 34, 3, 32, 82, 55, 89, 50, 37, 5, 64, 35, 9, 70};
    sort(arr);
    System.out.println(Arrays.toString(arr));
    System.out.println(verification(arr));
  }

  private static void sort(int[] nums) {
    // TODO implementation of sorting algorithm
    // 归并排序：采用分治的思想，拆分成两个有序数组，再合并
    int len = nums.length;
    if (len == 1) return;
    sort(nums, 0, len - 1);
  }

  private static void sort(int[] nums, int l, int r) {
    if (l >= r) return;
    int[] temp = new int[nums.length];
    // 拆分
    int mid = (l + r) >> 1;
    sort(nums, l, mid);
    sort(nums, mid + 1, r);
    for (int i = l; i <= r; i++) temp[i] = nums[i];
    int p1 = l, p2 = mid + 1;
    // 合并
    for (int i = l; i <= r; i++) {
      if (p1 == mid + 1) nums[i] = temp[p2++];
      else if (p2 == r + 1) nums[i] = temp[p1++];
      else if (temp[p1] <= temp[p2]) {
        nums[i] = temp[p1++];
      } else {
        nums[i] = temp[p2++];
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
