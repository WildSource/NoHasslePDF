package nohasslepdf.com.github.wildsource.gui;

import java.awt.Dimension;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

import net.miginfocom.swing.MigLayout;
import nohasslepdf.com.github.wildsource.listeners.ConvertButtonListener;
import nohasslepdf.com.github.wildsource.listeners.FileChooserButtonListener;

public class Window {
	private File[] pageData;
	private JFrame frame;
	private JFileChooser chooser;
	private JButton filechooserButton;
	private JButton convertButton;

	public Window() {
		this.pageData = null;
		framesetup();
		fileChooserSetup();
		fileChooserButtonSetup();
		convertButtonSetup();
		frameInit();
	}

	private void framesetup() {
		this.frame = new JFrame();
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new MigLayout());
		frame.setPreferredSize(new Dimension(1960, 1080));
		frame.setTitle("NoHasslePDF");
		frame.add(new JLabel("Image(s) shown in the preview is not the actual image quality"));
	}

	private void fileChooserSetup() {
		chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & PNG Images", "jpg", "png");
		chooser.setFileFilter(filter);
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		chooser.setMultiSelectionEnabled(true);
	}

	public void fileChooserButtonSetup() {
		filechooserButton = new JButton("browse");
		filechooserButton.addActionListener(new FileChooserButtonListener(chooser, this));
		filechooserButton.setPreferredSize(new Dimension(100, 30));
		frame.add(filechooserButton);
	}

	private void convertButtonSetup() {
		this.convertButton = new JButton("Convert");
		this.convertButton.setPreferredSize(new Dimension(100, 30));
		this.convertButton.addActionListener(new ConvertButtonListener(this));
		frame.add(this.convertButton, "wrap");
	}

	public void frameInit() {
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public File[] getPageData() {
		return pageData;
	}

	public void setPageData(File[] pageData) {
		this.pageData = pageData;
	}

	public JFileChooser getChooser() {
		return chooser;
	}

	public void setChooser(JFileChooser chooser) {
		this.chooser = chooser;
	}

	public JButton getFilechooserButton() {
		return filechooserButton;
	}

	public void setFilechooserButton(JButton filechooserButton) {
		this.filechooserButton = filechooserButton;
	}

	public JButton getConvertButton() {
		return convertButton;
	}

	public void setConvertButton(JButton convertButton) {
		this.convertButton = convertButton;
	}
}
