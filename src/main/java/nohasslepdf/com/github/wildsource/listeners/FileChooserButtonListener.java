package nohasslepdf.com.github.wildsource.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import nohasslepdf.com.github.wildsource.gui.PreviewPanel;
import nohasslepdf.com.github.wildsource.gui.Window;

public class FileChooserButtonListener implements ActionListener {

	JFileChooser chooser;

	Window window;

	PreviewPanel panel;

	public FileChooserButtonListener(JFileChooser chooser, Window window) {
		this.chooser = chooser;
		this.window = window;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		int status = chooser.showOpenDialog(null);
		if (this.panel != null) {
			this.window	.getFrame()
						.remove(this.panel);
			this.panel = null;
		}
		if (status == JFileChooser.APPROVE_OPTION) {
			this.panel = new PreviewPanel(chooser.getSelectedFiles());
			this.window	.getFrame()
						.add(new JScrollPane(this.panel), "wrap");
			this.window	.getFrame()
						.pack();
			this.window	.getFrame()
						.setExtendedState(this.window	.getFrame()
														.getExtendedState()
								| JFrame.MAXIMIZED_BOTH);
		}
		this.window.setPageData(this.chooser.getSelectedFiles());
	}

}
