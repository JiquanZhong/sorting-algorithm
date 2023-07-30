package com.jiquan.sortingAlgorithm;

import java.util.Arrays;

/**
 * @author ZHONG Jiquan
 * @create 29/07/2023 - 23:56
 */
public class HeapSort {
  public static void main(String[] args) {
    int[] arr = new int[] {22, 34, 3, 32, 82, 55, 89, 50, 37, 5, 64, 35, 9, 70};
    sort(arr);
    System.out.println(Arrays.toString(arr));
    System.out.println(verification(arr));
  }

  private static void sort(int[] nums) {
    // TODO implementation of sorting algorithm
    // 堆排序：
    // 利用堆的特性 最大值在最前面，建堆->取最大值
    int len = nums.length;
    // 建堆
    for (int i = len / 2; i >= 0; i--) {
      heapify(nums, i, len - 1);
    }
    // 取最大值并排序
    for (int i = len - 1; i > 0; i--) {
      swap(nums, 0, i);
      heapify(nums, 0, i - 1);
    }
  }

  /**
   * 从i往下堆化整个数组，数组长度到m索引位置
   * @param nums 被堆化堆数组
   * @param i 开始堆化堆索引
   * @param m 结束堆堆化堆索引
   */
  private static void heapify(int[] nums, int i, int m) {
    int left = 2 * i + 1;
    int right = 2 * i + 2;
    int largest = i;
    if(left <= m && nums[largest] < nums[left]){
      largest = left;
    }
    if (right <= m && nums[largest] < nums[right]) {
      largest = right;
    }
    if(largest != i){
      swap(nums, largest, i);
      heapify(nums, largest, m);
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
