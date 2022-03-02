package collection;

import java.util.List;
import java.util.ArrayList;

/**
 * You should complete the function in this class
 * <p>
 * Feel free to define any method and / or class you want
 */
class CollectionTest {


  /**
   * operation : x -> ((x * 2) + 3) ^ 5
   */
  public static List<Double> compute1(List<Integer> input) {
    List<Double> res = new ArrayList<>();
    for (Integer x: input) {
            res.add(Math.pow(x.doubleValue() * 2. + 3., 5.));
    }
    return res;
  }

  /**
   * operation : abc -> AbcAbc
   */
  public static List<String> compute2(List<String> input) {
    List<String> strList = new ArrayList<>();
    for (String str: input) {
      if(str.isEmpty()) {
        strList.add("");
        continue;
      }
      String cap = str.substring(0, 1).toUpperCase() + str.substring(1);
      strList.add(cap + cap);
    }
    return strList;
  }

}
