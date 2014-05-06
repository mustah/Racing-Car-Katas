package tddmicroexercises.textconvertor;

import java.io.IOException;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HtmlPagesConverterTest {
  @Test
  public void foo() throws IOException {
    HtmlPagesConverter converter = new HtmlPagesConverter("foo");
    assertEquals("fixme", converter.getFilename());
  }
}
