package tddmicroexercises.textconvertor;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HtmlTextConverterTest {

  @Test
  public void Convert_Empty_File_To_Html_Should_Return_Empty_String() throws Exception {
    assertEquals(new HtmlTextConverter(FileRepository.EMPTY).toHtml(), "");
  }

  @Test
  public void Convert_Simple_Html_File_To_Escaped_Characters() throws Exception {
    assertEquals(new HtmlTextConverter(FileRepository.SIMPLE).toHtml(), "&amp;lt;html&amp;gt;&amp;lt;/html&amp;gt;<br />");
  }
}
