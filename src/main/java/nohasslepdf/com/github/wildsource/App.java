package nohasslepdf.com.github.wildsource;

import nohasslepdf.com.github.wildsource.core.ConvertJpgStrategy;
import nohasslepdf.com.github.wildsource.core.ConverterContext;

public class App {

	public static void main(String[] args) {
		ConverterContext converter = new ConverterContext(new ConvertJpgStrategy());
		converter.convert("page.jpg");
	}
}
