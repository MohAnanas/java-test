package async;

import io.vavr.collection.List;
import io.vavr.*;
import io.vavr.control.Option;

import java.util.concurrent.CompletableFuture;

/**
 * You should complete the function in this class
 */
class AsyncTest {

  private static List<Enterprise> enterprises = List.of(
      new Enterprise("ent_1", "Google", "ceo_2"),
      new Enterprise("ent_2", "Facebook", "ceo_1")
  );

  private static List<Ceo> ceos = List.of(
      new Ceo("ceo_1", "Mark"),
      new Ceo("ceo_2", "Sundar"),
      new Ceo("ceo_3", "Bill")
  );

  public static CompletableFuture<Option<Ceo>> getCeoById(String ceo_id) {
    for (Ceo ceo: ceos) {
      if (ceo.id.equals(ceo_id))
        return CompletableFuture.completedFuture(Option.of(ceo));
    }
    return CompletableFuture.completedFuture(Option.none());
  }

  public static CompletableFuture<Option<Enterprise>> getEnterpriseByCeoId(String ceo_id) {
    for (Ceo ceo: ceos) {
      if (ceo.id.equals(ceo_id))
        for (Enterprise entity: enterprises) {
          if (entity.ceo_id.equals(ceo_id))
            return CompletableFuture.completedFuture(Option.of(entity));
        }
    }
    return CompletableFuture.completedFuture(Option.none());
  }

  public static CompletableFuture<Tuple2<Option<Ceo>, Option<Enterprise>>> getCEOAndEnterprise(String ceo_id) {
    try {
      return CompletableFuture.completedFuture(new Tuple2<>(getCeoById(ceo_id).get(), getEnterpriseByCeoId(ceo_id).get()));
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}
