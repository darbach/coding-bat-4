package edu.cnm.deepdive;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Functional2Test {

  private static Functional2 functional2 = new Functional2();

  @ParameterizedTest(name = "[{index}]Asserting noTeen({0}) == {1}")
  @MethodSource({"noTeen"})
  void noTeen(List<Integer> nums, List<Integer> expected) {
    assertArrayEquals(expected.toArray(), functional2.noTeen(nums).toArray());
  }

  static Stream<Arguments> noTeen() {
    return Stream.of(
        Arguments.of(List.of(12, 13, 19, 20), List.of(12, 20)),
        Arguments.of(List.of(1, 14, 1), List.of(1, 1)),
        Arguments.of(List.of(15), List.of()),
        Arguments.of(List.of(-15), List.of(-15)),
        Arguments.of(List.of(), List.of()),
        Arguments.of(List.of(0, 1, 2, -3), List.of(0, 1, 2, -3)),
        Arguments.of(List.of(15, 17, 19, 21, 19), List.of(21)),
        Arguments.of(List.of(-16, 2, 15, 3, 16, 25), List.of(-16, 2, 3, 25))
    );
  }

}