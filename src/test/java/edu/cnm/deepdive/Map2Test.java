package edu.cnm.deepdive;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Map2Test {

  Map2 map2 = new Map2();

  @ParameterizedTest(name = "[{index}]Asserting wordCount({0}) == {1}")
  @MethodSource({"wordCount"})
  void wordCount(String[] strings, Map<String, Integer> expected) {
    assertTrue(mapEquals(expected, map2.wordCount(strings)));
  }

  static Stream<Arguments> wordCount() {
    return Stream.of(
        Arguments.of(new String[]{"a", "b", "a", "c", "b"}, Map.of("a", 2, "b", 2, "c", 1)),
        Arguments.of(new String[]{"c", "b", "a"}, Map.of("a", 1, "b", 1, "c", 1)),
        Arguments.of(new String[]{"c", "c", "c", "c"}, Map.of("c", 4)),
        Arguments.of(new String[]{}, Map.of()),
        Arguments.of(new String[]{"this", "and", "this", ""}, Map.of("", 1, "and", 1, "this", 2)),
        Arguments.of(new String[]{"x", "y", "x", "Y", "X"}, Map.of("x", 2, "X", 1, "y", 1, "Y", 1)),
        Arguments.of(new String[]{"123", "0", "123", "1"}, Map.of("0", 1, "1", 1, "123", 2)),
        Arguments
            .of(new String[]{"d", "a", "e", "d", "a", "d", "b", "b", "z", "a", "a", "b", "z", "x",
                    "b", "f", "x", "two", "b", "one", "two"},
                Map.of("a", 4, "b", 5, "d", 3, "e", 1, "f", 1, "one", 1, "x", 2, "z", 2, "two", 2)),
        Arguments.of(new String[]{"apple", "banana", "apple", "apple", "tea", "coffee", "banana"},
            Map.of("banana", 2, "apple", 3, "tea", 1, "coffee", 1))
    );
  }

  private static boolean mapEquals(Map<String, Integer> m1, Map<String, Integer> m2) {
    boolean areEqual = true;
    if ((m1 == null) || (m2 == null) || (m1.size() != m2.size())) {
      areEqual = false;
    } else {
      for (String m1Key : m1.keySet()){
        if (!m1.get(m1Key).equals(m2.get(m1Key))) {
          areEqual = false;
          break;
        }
      }
    }
    return areEqual;
  }

}