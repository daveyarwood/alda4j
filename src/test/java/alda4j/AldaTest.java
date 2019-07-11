package alda4j;

import org.junit.jupiter.api.*;

public class AldaTest {
  private String[] inputs = {"piano: a b c", "guitar: o2 c1/e/g/>c"};

  @BeforeAll
  public static void setup() {
    System.out.println("Initializing...");
    Alda.initialize();
  }

  @Test
  public void testParse() {
    for (String input : inputs) {
      System.out.println("Parsing input: " + input);
      ClojureUtil.prn(Alda.parse(input));
    }
  }

  @Test
  public void testPlay() {
    for (String input : inputs) {
      System.out.println("Playing input: " + input);
      Alda.play(input);
    }
  }

  private String[] inputs2 = {"trumpet: o4 c8 d", "e f", "g a b >", "c2"};

  @Test
  public void testPlayAndContinue() {
    String history = "";

    for (String input : inputs2) {
      System.out.println("\nHistory:\n" + history);
      System.out.println("Input:\n" + input);
      Alda.play(input, history);
      history += input + "\n";
    }
  }
}

