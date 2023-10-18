package nohasslepdf.com.github.wildsource.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;

public class FileChooserButtonListener implements ActionListener {

	JFileChooser chooser;

	public FileChooserButtonListener(JFileChooser chooser) {
		this.chooser = chooser;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		int status = chooser.showOpenDialog(null);
	}

}
