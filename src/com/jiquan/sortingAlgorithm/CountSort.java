package com.jiquan.sortingAlgorithm;

import java.util.Arrays;

/**
 * @author ZHONG Jiquan
 * @create 29/07/2023 - 23:56
 */
public class CountSort {
  public static void main(String[] args) {
    int[] arr = new int[] {22, 34, 3, 32, 82, 55, 89, 50, 37, 5, 64, 35, 9, 70};
    sort(arr);
    System.out.println(Arrays.toString(arr));
    System.out.println(verification(arr));
  }

  private static void sort(int[] nums) {
    // TODO implementation of sorting algorithm
    // 计数排序：
    // 使用空间换时间，nums的数据在0-max范围
    // 创建一个bucket数组，长度为max+1存放不同数的出现频率

    // 计数
    int maxValue = getMax(nums);
    int[] buckets = new int[maxValue + 1];
    for (int num : nums) buckets[num]++;

    // 排序
    int sortIndex = 0;
    for (int i = 0; i < buckets.length; i++) {
      while (buckets[i] > 0) {
        nums[sortIndex++] = i;
        buckets[i]--;
      }
    }
  }

  private static int getMax(int[] nums) {
    int maxValue = nums[0];
    for (int value : nums) {
      if (value > maxValue) maxValue = value;
    }
    return maxValue;
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
