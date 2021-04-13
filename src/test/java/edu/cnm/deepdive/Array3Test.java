package edu.cnm.deepdive;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Array3Test {

  @ParameterizedTest
  @MethodSource("canBalance")
  void canBalance(int[] nums, boolean expected) {
    assertEquals(expected, Array3.canBalance3(nums));
  }

  static Stream<Arguments> canBalance() {
    return Stream.of(
        Arguments.of(new int[]{1, 1, 1, 2, 1}, true),
        Arguments.of(new int[]{2, 1, 1, 2, 1}, false),
        Arguments.of(new int[]{10, 10}, true),
        Arguments.of(new int[]{10, 0, 1, -1, 10}, true),
        Arguments.of(new int[]{10, -1, 1, 0, 10}, true),
        Arguments.of(new int[]{1, 1, 1, 1, 4}, true),
        Arguments.of(new int[]{2, 1, 1, 1, 4}, false),
        Arguments.of(new int[]{2, 3, 4, 1, 2}, false),
        Arguments.of(new int[]{1, 2, 3, 1, 0, 2, 3}, true),
        Arguments.of(new int[]{1, 2, 3, 1, 0, 1, 3}, false),
        Arguments.of(new int[]{1}, false),
        Arguments.of(new int[]{1, 1, 1, 2, 1}, true)
    );
  }

}