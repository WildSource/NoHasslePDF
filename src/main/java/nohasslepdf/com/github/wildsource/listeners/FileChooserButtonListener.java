package nohasslepdf.com.github.wildsource.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import nohasslepdf.com.github.wildsource.gui.PreviewPanel;

public class FileChooserButtonListener implements ActionListener {

	JFileChooser chooser;

	JFrame frame;

	PreviewPanel panel;

	public FileChooserButtonListener(JFileChooser chooser, JFrame frame) {
		this.chooser = chooser;
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		int status = chooser.showOpenDialog(null);
		if (this.panel != null) {
			this.frame.remove(this.panel);
			this.panel = null;
		}
		if (status == JFileChooser.APPROVE_OPTION) {
			this.panel = new PreviewPanel(chooser.getSelectedFiles());
			this.frame.add(new JScrollPane(this.panel), "wrap");
			this.frame.pack();
			this.frame.setExtendedState(this.frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		}
	}

}
