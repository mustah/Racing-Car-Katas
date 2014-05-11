package tddmicroexercises.textconvertor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HtmlTextConverter {

  private final String filename;
  private final EscapeStrategy escapeStrategy;

  public HtmlTextConverter(String filename, EscapeStrategy htmlEscapeStrategy) {
    this.filename = filename;
    this.escapeStrategy = htmlEscapeStrategy;
  }

  public String toHtml() throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
      String html = "";
      for (String line = reader.readLine(); line != null; line = reader.readLine()) {
        html += escapeStrategy.escapeHtml(line);
        html += "<br />";
      }
      return html;
    }
  }
}
