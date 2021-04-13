package edu.cnm.deepdive;

import java.util.List;
import java.util.stream.Collectors;

public class Functional1 {

  /**
   * Given a list of strings, return a list where each string is replaced by 3 copies of the string
   * concatenated together.
   *
   * copies3(["a", "bb", "ccc"]) → ["aaa", "bbbbbb", "ccccccccc"]
   * copies3(["24", "a", ""]) → ["242424", "aaa", ""]
   * copies3(["hello", "there"]) → ["hellohellohello", "theretherethere"]
   *
   * @param strings list of String values
   * @return mutated list
   */
  public List<String> copies3(List<String> strings) {
    return strings.stream()
        .map((s) -> s + s + s)
        .collect(Collectors.toList());
  }

}
