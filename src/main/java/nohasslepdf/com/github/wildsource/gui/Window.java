package nohasslepdf.com.github.wildsource.gui;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

import net.miginfocom.swing.MigLayout;

public class Window {
	private JFrame frame;
	private JFileChooser chooser;

	public Window() {
		framesetup();
		fileChooserSetup();
	}

	private void framesetup() {
		this.frame = new JFrame();
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(640, 480);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new MigLayout());
		frame.setTitle("AC4J");
		frame.setVisible(true);
	}

	private void fileChooserSetup() {
		chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & PNG Images", "jpg", "png");
		chooser.setFileFilter(filter);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
