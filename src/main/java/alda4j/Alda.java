package alda4j;

import clojure.java.api.Clojure;
import clojure.lang.APersistentMap;
import clojure.lang.Var;

public class Alda {
  public static void initialize() {
    ClojureUtil.call("alda.worker/start-alda-environment!");
  }

  public static APersistentMap parse(String input) {
    return (APersistentMap)ClojureUtil.call("alda.parser/parse-input", input);
  }

  public static void play(String input, String history) {
    APersistentMap opts = ClojureUtil.hashMap(
      ClojureUtil.keyword("history"), history
    );
    ClojureUtil.call("alda.worker/run-play-job!", input, opts);
  }

  public static void play(String input) {
    play(input, "");
  }
}
