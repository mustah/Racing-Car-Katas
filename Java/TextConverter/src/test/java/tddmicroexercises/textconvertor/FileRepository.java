package tddmicroexercises.textconvertor;

final class FileRepository {

  private static final String TEST_RESOURCES_BASE_DIRECTORY = "/Users/must/repos/my-projects/katas/Racing-Car-Katas/Java/TextConverter/src/test/testresources/tddmicroexercises/textconverter/";

  protected static final String EMPTY = TEST_RESOURCES_BASE_DIRECTORY + "empty.html";
  protected static final String FILE_1 = TEST_RESOURCES_BASE_DIRECTORY + "file1.html";
  protected static final String FILE_2 = TEST_RESOURCES_BASE_DIRECTORY + "file2.html";

  private FileRepository() {
  }
}
