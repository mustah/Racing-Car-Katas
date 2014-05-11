package tddmicroexercises.textconvertor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HtmlTextConverter {

  private final String filename;

  public HtmlTextConverter(String filename) {
    this.filename = filename;
  }

  public String toHtml() throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
      String html = "";
      for (String line = reader.readLine(); line != null; line = reader.readLine()) {
        html += StringEscapeUtils.escapeHtml(line);
        html += "<br />";
      }
      return html;
    }
  }
}
