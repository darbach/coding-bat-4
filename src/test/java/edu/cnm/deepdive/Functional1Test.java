package edu.cnm.deepdive;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Functional1Test {

  private static Functional1 functional1 = new Functional1();

  @ParameterizedTest(name = "[{index}]Asserting copies3({0}) == {1}")
  @MethodSource({"copies3"})
  void copies3(List<String> strings, List<String> expected) {
    assertArrayEquals(expected.toArray(), functional1.copies3(strings).toArray());
  }

  static Stream<Arguments> copies3() {
    return Stream.of(
        Arguments.of(List.of("a", "bb", "ccc"), List.of("aaa", "bbbbbb", "ccccccccc")),
        Arguments.of(List.of("24", "a", ""), List.of("242424", "aaa", "")),
        Arguments.of(List.of("hello", "there"), List.of("hellohellohello", "theretherethere")),
        Arguments.of(List.of("no"), List.of("nonono")),
        Arguments.of(List.of(), List.of()),
        Arguments.of(List.of("this", "and", "that", "and"),
            List.of("thisthisthis", "andandand", "thatthatthat", "andandand"))
        );
  }
}