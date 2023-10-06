package nohasslepdf.com.github.wildsource.core.converters;

public class ConverterContext {
	private ConverterStrategy strategy;

	public ConverterContext() {
		this.strategy = null;
	}

	public ConverterContext(ConverterStrategy strategy) {
		this.strategy = strategy;
	}

	public void convert(String filePath) {
		this.strategy.convert(filePath);
	}

	public ConverterStrategy getStategy() {
		return strategy;
	}

	public void setStategy(ConverterStrategy strategy) {
		this.strategy = strategy;
	}
}
