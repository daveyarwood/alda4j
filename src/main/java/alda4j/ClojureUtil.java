package alda4j;

import clojure.java.api.Clojure;
import clojure.lang.IFn;
import clojure.lang.ISeq;
import clojure.lang.Keyword;
import clojure.lang.Symbol;
import clojure.lang.ArraySeq;
import clojure.lang.PersistentHashMap;

public class ClojureUtil {
  public static void require(String namespace) {
    IFn require = Clojure.var("clojure.core", "require");
    require.invoke(Symbol.create(namespace));
  }

  public static Object call(String fn, Object... args) {
    Symbol var = (Symbol)Clojure.read(fn);
    IFn require = Clojure.var("clojure.core", "require");
    require.invoke(Symbol.create(var.getNamespace()));
    ISeq argsSeq = ArraySeq.create(args);
    return Clojure.var(var.getNamespace(), var.getName()).applyTo(argsSeq);
  }

  public static PersistentHashMap hashMap(Object... args) {
    return (PersistentHashMap)call("clojure.core/hash-map", args);
  }

  public static Keyword keyword(String name) {
    return (Keyword)call("clojure.core/keyword", name);
  }

  public static void prn(Object... args) {
    call("clojure.core/prn", args);
  }
}
