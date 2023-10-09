package nohasslepdf.com.github.wildsource.core.converters;

public interface ConverterStrategy {
	int DEFAULT_PAGE_WIDTH = 2480;
	int DEFAULT_PAGE_HEIGHT = 3508;

	public void convert(String filePath);
}
