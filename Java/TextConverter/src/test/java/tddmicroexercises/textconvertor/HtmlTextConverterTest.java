package tddmicroexercises.textconvertor;

import java.io.IOException;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static tddmicroexercises.textconvertor.FileRepository.EMPTY;
import static tddmicroexercises.textconvertor.FileRepository.FILE_1;
import static tddmicroexercises.textconvertor.FileRepository.FILE_2;

public class HtmlTextConverterTest {

  @Test
  public void Convert_Empty_File_To_Html_Should_Return_Empty_String() throws Exception {
    assertToHtml(EMPTY, "");
  }

  @Test
  public void Convert_Simple_Html_File_To_Escaped_String() throws Exception {
    assertToHtml(FILE_1, "&amp;lt;html&amp;gt;&amp;lt;/html&amp;gt;<br />");
  }

  @Test
  public void Convert_Html_File_With_Two_Lines_To_Escaped_String() throws Exception {
    assertToHtml(FILE_2, "&amp;lt;html&amp;gt;<br />&amp;lt;head&amp;gt;&amp;lt;/head&amp;gt;<br />&amp;lt;/html&amp;gt;<br />");
  }

  private void assertToHtml(String filename, String actual) throws IOException {
    assertEquals(new HtmlTextConverter(filename).toHtml(), actual);
  }
}
