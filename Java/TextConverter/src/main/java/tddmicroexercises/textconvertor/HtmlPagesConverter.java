package tddmicroexercises.textconvertor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HtmlPagesConverter {

  private final List<Integer> breaks = new ArrayList<>();
  private final String filename;

  public HtmlPagesConverter(String filename) throws IOException {
    this.filename = filename;
    this.breaks.add(0);
    findPageBreaks(filename);
  }

  private void findPageBreaks(String filename) throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
      int cumulativeCharCount = 0;
      String line = reader.readLine();
      while (line != null) {
        cumulativeCharCount += line.length() + 1; // add one for the newline
        if (line.contains("PAGE_BREAK")) {
          breaks.add(cumulativeCharCount);
        }
        line = reader.readLine();
      }
    }
  }

  public String getHtmlForPageAt(int page) throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
      reader.skip(breaks.get(page));
      StringBuilder htmlPage = new StringBuilder();
      String line = reader.readLine();
      while (line != null) {
        if (line.contains("PAGE_BREAK")) {
          break;
        }
        htmlPage.append(StringEscapeUtils.escapeHtml(line));
        htmlPage.append("<br />");

        line = reader.readLine();
      }
      return htmlPage.toString();
    }
  }

  public String getFilename() {
    return this.filename;
  }
}
