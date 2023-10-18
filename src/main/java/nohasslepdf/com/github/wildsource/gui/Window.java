package nohasslepdf.com.github.wildsource.gui;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

import net.miginfocom.swing.MigLayout;
import nohasslepdf.com.github.wildsource.listeners.FileChooserButtonListener;

public class Window {
	private JFrame frame;
	private JFileChooser chooser;
	private JButton filechooserButton;

	public Window() {
		framesetup();
		fileChooserSetup();
		fileChooserButtonSetup();
		frameInit();
	}

	private void framesetup() {
		this.frame = new JFrame();
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new MigLayout());
		frame.setPreferredSize(new Dimension(400, 280));
		frame.setTitle("NoHasslePDF");
	}

	private void fileChooserSetup() {
		chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & PNG Images", "jpg", "png");
		chooser.setFileFilter(filter);
	}

	public void fileChooserButtonSetup() {
		filechooserButton = new JButton("browse");
		filechooserButton.addActionListener(new FileChooserButtonListener(chooser));
		filechooserButton.setPreferredSize(new Dimension(100, 30));
		filechooserButton.setVisible(true);
		frame.add(filechooserButton);
	}

	public void frameInit() {
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
