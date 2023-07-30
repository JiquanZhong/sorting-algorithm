package com.jiquan.sortingAlgorithm;

import java.util.Arrays;

/**
 * @author ZHONG Jiquan
 * @create 29/07/2023 - 23:56
 */
public class BucketSort {
  public static void main(String[] args) {
    int[] arr = new int[] {22, 34, 3, 32, 82, 55, 89, 50, 37, 5, 64, 35, 9, 70};
    sort(arr);
    System.out.println(Arrays.toString(arr));
    System.out.println(verification(arr));
  }

  private static void sort(int[] nums) {
    // TODO implementation of sorting algorithm
    // 计数排序的提升版：
    // 把数据均匀分布在桶内，再对桶内进行插入排序
    // 最后遍历桶
    int len = nums.length;
    if(len == 0) return;

    // 把数据放入桶
    int minValue = nums[0];
    int maxValue = nums[0];
    for(int num : nums){
      if(minValue > num) minValue = num;
      if(maxValue < num) maxValue = num;
    }
    int bucketSize = 5;
    int bucketNum = (maxValue - minValue) / bucketSize + 1;
    int[][] buckets = new int[bucketNum][0];
    for(int num : nums){
      int bucketIndex = (num - minValue) / bucketSize;
      arrAppend(buckets, bucketIndex, num);
    }

    // 对桶内数据进行插入排序
    int sortIndex = 0;
    for(int[] bucket : buckets){
      if(bucket.length == 0) continue;
      // 排序
      InsertionSort.sort(bucket);
      // 装桶
      for(int num : bucket){
        nums[sortIndex++] = num;
      }
    }

  }

  /**
   * 添加数据，并扩容数组
   * @param buckets 要扩容的数组
   * @param index 二维数组中目标数组索引
   * @param value 新数据
   * @return 扩容后的数组
   */
  private static void arrAppend(int[][] buckets, int index, int value) {
    buckets[index] = Arrays.copyOf(buckets[index], buckets[index].length + 1);
    buckets[index][buckets[index].length - 1] = value;
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
