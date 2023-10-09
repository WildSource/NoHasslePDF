package nohasslepdf.com.github.wildsource;

import nohasslepdf.com.github.wildsource.core.converters.ConverterContext;
import nohasslepdf.com.github.wildsource.core.converters.strategies.ConvertJpgStrategy;
import nohasslepdf.com.github.wildsource.core.converters.strategies.ConvertPngStrategy;

public class App {

	public static void main(String[] args) {
		ConverterContext converter = new ConverterContext(new ConvertPngStrategy());
		converter.convert("PNGFileTest.png");

		converter.setStategy(new ConvertJpgStrategy());
		converter.convert("JPGFileTest.jpg");
	}
}
