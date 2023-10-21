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

	JScrollPane scrollPane;

	public FileChooserButtonListener(JFileChooser chooser, Window window) {
		this.chooser = chooser;
		this.window = window;
		this.panel = null;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		int status = chooser.showOpenDialog(null);
		resetPreview();
		if (status == JFileChooser.APPROVE_OPTION) {
			this.panel = new PreviewPanel(chooser.getSelectedFiles());
			this.scrollPane = new JScrollPane(this.panel);
			this.window	.getFrame()
						.add(this.scrollPane, "wrap");
			this.window	.getFrame()
						.pack();
			this.window	.getFrame()
						.setExtendedState(this.window	.getFrame()
														.getExtendedState()
								| JFrame.MAXIMIZED_BOTH);
		}
		this.window.setPageData(this.chooser.getSelectedFiles());
	}

	public void resetPreview() {
		if (this.panel != null) {
			this.window	.getFrame()
						.remove(this.scrollPane);
			this.panel = null;
		}
	}

}
