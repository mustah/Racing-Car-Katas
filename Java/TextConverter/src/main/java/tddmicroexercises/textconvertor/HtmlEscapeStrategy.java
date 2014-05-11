package tddmicroexercises.textconvertor;

public class HtmlEscapeStrategy implements EscapeStrategy {

  @Override
  public String escapeHtml(String line) {
    return StringEscapeUtils.escapeHtml(line);
  }
}