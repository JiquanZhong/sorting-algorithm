package com.jiquan.sortingAlgorithm;

import java.util.Arrays;

/**
 * @author ZHONG Jiquan
 * @create 29/07/2023 - 23:56
 */
public class HillSort {
  public static void main(String[] args) {
    int[] arr = new int[]{22, 34, 3, 32, 82, 55, 89, 50, 37, 5, 64, 35, 9, 70};
    sort(arr);
    System.out.println(Arrays.toString(arr));
    System.out.println(verification(arr));
  }

  private static void sort(int[] nums) {
    // TODO implementation of sorting algorithm
    // 有间隔的插入排序
    int len = nums.length;
    if(len == 1) return;

    for(int gap = len / 2; gap >= 1; gap /= 2){
      for(int i = gap; i < len; i++){
        int currentNum = nums[i];
        int insertIndex = i - gap;
        while(insertIndex >= 0 && currentNum < nums[insertIndex]){
          nums[insertIndex + gap] = nums[insertIndex];
          insertIndex -= gap;
        }
        nums[insertIndex + gap] = currentNum;
      }
    }
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
