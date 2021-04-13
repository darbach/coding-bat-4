package edu.cnm.deepdive;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Recursion1Test {

  private static Recursion1 recursion1 = new Recursion1();

  @ParameterizedTest(name = "[{index}]Asserting changeXY({0}) == {1}")
  @MethodSource("changeXY")
  void changeXY(String str, String expected) {
    assertEquals(expected, recursion1.changeXY(str));
  }

  static Stream<Arguments> changeXY() {
    return Stream.of(
        Arguments.of("codex", "codey"),
        Arguments.of("xxhixx", "yyhiyy"),
        Arguments.of("xhixhix", "yhiyhiy"),
        Arguments.of("hiy", "hiy"),
        Arguments.of("h", "h"),
        Arguments.of("x", "y"),
        Arguments.of("", ""),
        Arguments.of("xxx", "yyy"),
        Arguments.of("yyhxyi", "yyhyyi"),
        Arguments.of("hihi", "hihi")
    );
  }
}