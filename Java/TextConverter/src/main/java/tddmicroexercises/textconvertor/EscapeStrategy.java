package tddmicroexercises.textconvertor;

public interface EscapeStrategy {

  /**
   * @param line represents any any line before newline character.
   *
   * @return String containing escaped html code.
   */
  String escapeHtml(String line);
}
