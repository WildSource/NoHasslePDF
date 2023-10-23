package nohasslepdf.com.github.wildsource.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JProgressBar;

import nohasslepdf.com.github.wildsource.core.converters.ConverterContext;
import nohasslepdf.com.github.wildsource.core.converters.ConverterStrategy;
import nohasslepdf.com.github.wildsource.core.converters.strategies.ConvertJpgStrategy;
import nohasslepdf.com.github.wildsource.core.converters.strategies.ConvertPngStrategy;
import nohasslepdf.com.github.wildsource.gui.Window;

public class ConvertButtonListener implements ActionListener {
	Window window;
	ConverterContext converter;
	ConverterStrategy jpg;
	ConverterStrategy png;
	JProgressBar progress;

	public ConvertButtonListener(Window window) {
		this.window = window;
		this.converter = new ConverterContext();
		this.jpg = new ConvertJpgStrategy();
		this.png = new ConvertPngStrategy();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		File[] pages = window.getPageData();

		addProgressBar(pages.length);
		for (int i = 0; i < pages.length; i++) {
			if (pages[i].getName()
						.contains("jpg")) {
				converter.setStategy(this.jpg);
			}
			if (pages[i].getName()
						.contains("png")) {
				converter.setStategy(this.png);
			}
			converter.convert(pages[i].getAbsolutePath());
			this.progress.setValue(i);
		}
	}

	private void addProgressBar(int max) {
		this.progress = new JProgressBar(0, max);
		this.progress.setValue(0);
		this.progress.setStringPainted(true);
		this.window	.getFrame()
					.add(this.progress);
	}
}
