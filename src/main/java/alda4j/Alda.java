package alda4j;

import clojure.java.api.Clojure;
import clojure.lang.Var;
import clojure.lang.PersistentHashMap;

public class Alda {
  public static void initialize() {
    ClojureUtil.require("alda.parser");
    ClojureUtil.require("alda.lisp");
    ClojureUtil.require("alda.sound");
    ClojureUtil.call("alda.sound.midi/open-midi-synth!");
    ClojureUtil.call("alda.sound.midi/open-midi-sequencer!");
  }

  public static PersistentHashMap parse(String input) {
    return (PersistentHashMap)ClojureUtil.call(
      "alda.parser/parse-input", input
    );
  }

  public static void play(PersistentHashMap score) {
    ClojureUtil.call("alda.sound/play!", score);
  }

  public static void play(String input) {
    play(parse(input));
  }
}
