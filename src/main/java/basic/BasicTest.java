package basic;

import io.vavr.control.Option;

/**
 * For this basic test, you should not use any library. e.g. you should not use Math.pow for power method
 */
public class BasicTest {

  /**
   * return i ^ n for positive Integer, None otherwise
   * alse return None in case of errors
   */
  public static Option<Integer> power(Integer i, Integer n) {
    if ((i < 0 && ((n % 2) == 1)) || n < 0 )
      return Option.none();
    else {
      int res = 1;
      for (int index = n; index > 0; index = index - 1) {
        if ((double) res * i >= Integer.MAX_VALUE)
          return Option.none();
        res = res * i;
      }
      System.out.println(res);
      System.out.println(Option.of(res));

      return Option.of(res);
    }
  }
}
