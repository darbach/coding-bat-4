package edu.cnm.deepdive;

public class Recursion1 {

  /**
   * Given a string, compute recursively (no loops) a new string where all the lowercase 'x' chars
   * have been changed to 'y' chars.
   *
   * changeXY("codex") → "codey"
   * changeXY("xxhixx") → "yyhiyy"
   * changeXY("xhixhix") → "yhiyhiy"
   *
   * @param str
   * @return
   */
  public String changeXY(String str) {
    if (str.length() == 0) {
      return str;
    }
    String firstChar = str.substring(0, 1);
    return ((firstChar.equals("x")) ? "y": firstChar) + changeXY(str.substring(1, str.length()));
  }

}
