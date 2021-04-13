package edu.cnm.deepdive;

import java.util.HashMap;
import java.util.Map;

public class Map2 {

  /**
   * The classic word-count algorithm: given an array of strings, return a Map<String, Integer> with
   * a key for each different string, with the value the number of times that string appears in the
   * array.
   *
   * wordCount(["a", "b", "a", "c", "b"]) → {"a": 2, "b": 2, "c": 1}
   * wordCount(["c", "b", "a"]) → {"a": 1, "b": 1, "c": 1}
   * wordCount(["c", "c", "c", "c"]) → {"c": 4}
   *
   * @param strings
   * @return
   */
  public Map<String, Integer> wordCount(String[] strings) {
    Map<String, Integer> counts = new HashMap<>();
    for (String key : strings) {
      int count;
      if (!counts.containsKey(key)) {
        count = 1;
      } else {
        count = counts.get(key) + 1;
      }
      counts.put(key, count);
    }
    return counts;
  }


}
