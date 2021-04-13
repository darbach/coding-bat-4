package edu.cnm.deepdive;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Functional2 {

  /**
   * Given a list of integers, return a list of those numbers, omitting any that are between 13 and
   * 19 inclusive.
   *
   * noTeen([12, 13, 19, 20]) → [12, 20]
   * noTeen([1, 14, 1]) → [1, 1]
   * noTeen([15]) → []
   *
   * @param nums
   * @return
   */
  public List<Integer> noTeen(List<Integer> nums) {
    return nums.stream()
        .filter((value) -> (value < 13 || value > 19))
        .collect(Collectors.toList());
  }

}
