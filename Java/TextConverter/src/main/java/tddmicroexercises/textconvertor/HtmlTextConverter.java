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
      String line = reader.readLine();
      String html = "";
      while (line != null) {
        html += StringEscapeUtils.escapeHtml(line);
        html += "<br />";
        line = reader.readLine();
      }
      return html;
    }
  }

  public String getFilename() {
    return this.filename;
  }
}
