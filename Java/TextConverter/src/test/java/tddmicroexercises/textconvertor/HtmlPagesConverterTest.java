package tddmicroexercises.textconvertor;

import java.io.IOException;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HtmlPagesConverterTest {

  @Test
  public void foo() throws IOException {
    assertThat(FileRepository.EMPTY).isEqualTo(new HtmlPagesConverter(FileRepository.EMPTY).getFilename());
  }
}
