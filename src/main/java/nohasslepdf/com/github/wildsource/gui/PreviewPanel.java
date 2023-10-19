package nohasslepdf.com.github.wildsource.gui;

import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class PreviewPanel extends JPanel {
	private static final long serialVersionUID = 3326543850180267075L;

	private File[] files;

	private ImageIcon[] pages;

	public PreviewPanel() {
	}

	public PreviewPanel(File[] files) {
		setLayout(new MigLayout());
		this.files = files;
		this.pages = new ImageIcon[files.length];
		populatePageArray();
		reducePageSize();
		displayPages();
	}

	private void populatePageArray() {
		for (int i = 0; i < files.length; i++) {
			this.pages[i] = new ImageIcon(files[i].getAbsolutePath());
		}
	}

	private void reducePageSize() {
		for (int i = 0; i < pages.length; i++) {
			this.pages[i] = new ImageIcon(this.pages[i]	.getImage()
														.getScaledInstance(280, 330, Image.SCALE_FAST));
		}
	}

	private void displayPages() {
		for (int i = 0; i < pages.length; i++) {
			add(new JLabel(pages[i]));
		}
	}

	public File[] getFiles() {
		return files;
	}

	public void setFiles(File[] files) {
		this.files = files;
	}
}
