package tddmicroexercises.textconvertor;

final class StringEscapeUtils {

  private StringEscapeUtils() {
  }

  public static String escapeHtml(String input) {
    String output = input.replace("'", "&quot;");
    output = output.replace("<", "&lt;");
    output = output.replace(">", "&gt;");
    output = output.replace("\"", "&quot;");
    output = output.replace("&", "&amp;");
    return output;
  }
}
