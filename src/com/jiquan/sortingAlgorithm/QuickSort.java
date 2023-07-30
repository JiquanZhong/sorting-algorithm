package com.jiquan.sortingAlgorithm;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * @author ZHONG Jiquan
 * @create 29/07/2023 - 23:56
 */
public class QuickSort {
  public static void main(String[] args) {
    int[] arr = new int[]{22, 34, 3, 32, 82, 55, 89, 50, 37, 5, 64, 35, 9, 70};
    sort(arr);
    System.out.println(Arrays.toString(arr));
    System.out.println(verification(arr));
  }

  private static void sort(int[] nums) {
    // TODO implementation of sorting algorithm
    // 快速排序：分治
    // 找出一个pivot，比它小的放左边，比它大的放右边，此时pivot位置固定下来
    // 对左右子序列继续重复此步骤
    sort(nums, 0, nums.length - 1);
  }

  private static void sort(int[] nums, int l, int r) {
    if(l >= r) return;
    // pivot 随即化
    int randomIndex =(int)( l + ( r - l + 1) * Math.random());
    swap(nums, l, randomIndex);
    //分区
    int pivot = nums[l];
    int p = l, q = r;
    while(p < q){
      //一定是p=q时跳出循环
      while(nums[q] >= pivot && p < q) q--;
      while (nums[p] <= pivot && p < q) p++;
      swap(nums, p, q);
    }
    swap(nums, p, l);
    sort(nums, l, p - 1);
    sort(nums, p + 1, r);
  }

  private static void swap(int[] nums, int i, int j){
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
