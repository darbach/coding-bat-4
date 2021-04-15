package edu.cnm.deepdive;

import java.util.Arrays;

public class Array3 {

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
 public boolean canBalance(int[] nums) { // O(n) time, 0(1) space
    boolean balanced = false;
    int rightSum = 0;
    for (int value : nums) { //calculate the total sum for a later add/subtract pass
      rightSum += value;
    }
    if (rightSum == 0) { // special case
      balanced = true;
    } else if (rightSum % 2 == 0){ // an odd sum cannot be balanced
      int leftSum = 0;
      for (int value : nums) {
        if ((leftSum += value) == (rightSum -= value)) {
          balanced = true;
          break;
        }
      }
    }
    return balanced;
 }

}
