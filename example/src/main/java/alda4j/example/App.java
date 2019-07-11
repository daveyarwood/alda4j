package alda4j.example;

import alda4j.Alda;
import alda4j.ClojureUtil;
import java.io.IOException;
import jline.console.ConsoleReader;

public class App {
  public static void main(String[] args) throws IOException {
    ConsoleReader rdr = new ConsoleReader();
    rdr.setExpandEvents(false);

    System.out.println("Initializing...");
    Alda.initialize();

    while (!Thread.currentThread().isInterrupted()) {
      String input = rdr.readLine("alda> ");

      if (input == null) break; // handle Ctrl-D
      if (input.length() == 0) continue; // handle empty line

      try {
        Alda.play(input);
      } catch (Throwable t) {
        t.printStackTrace();
      }
    }

    System.exit(0);
  }
}
