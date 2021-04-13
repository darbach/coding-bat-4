package edu.cnm.deepdive;

import java.util.Arrays;

public abstract class Array3 {

  /**
   * Given a non-empty array, return true if there is a place to split the array so that the sum of
   * the numbers on one side is equal to the sum of the numbers on the other side.
   *
   * canBalance([1, 1, 1, 2, 1]) → true
   * canBalance([2, 1, 1, 2, 1]) → false
   * canBalance([10, 10]) → true
   *
   * @param nums a set of numbers
   * @return whether there is a place to split the array
   */
  public static boolean canBalance(int[] nums) {
    boolean found = false;
    int i = 1;
    while(!found && i < nums.length) {
      int[] left = Arrays.copyOfRange(nums, 0, i);
      int[] right = Arrays.copyOfRange(nums, i, nums.length);
      i++;
      if (Arrays.stream(left).sum() == Arrays.stream(right).sum()) {
        found = true;
      }
    }
    return found;
  }

  public static boolean canBalance2(int[] nums) {
    //Works but coding bat doesn't like System.arraycopy.
    boolean found = false;
    int i = 1;
    while(!found && i < nums.length) {
      int[] left = new int[i];
      int[] right = new int[nums.length - i];
      System.arraycopy(nums, 0, left, 0, i);
      System.arraycopy(nums, i, right, 0, nums.length - i);
      i++;
      if (Arrays.stream(left).sum() == Arrays.stream(right).sum()) {
        found = true;
      }
    }
    return found;
  }

  public static boolean canBalance3(int[] nums) {
    // This one is buggy.
    int leftSum = 0;
    int rightSum = 0;
    int leftIter = 0;
    int rightIter = nums.length - 1;
    while (leftIter <= rightIter) {
      if (leftSum <= rightSum) {
        leftSum += nums[leftIter];
        leftIter++;
      } else { //(leftSum > rightSum)
        rightSum += nums[rightIter];
        rightIter--;
      }
    }
    return (leftSum == rightSum);
  }

}
