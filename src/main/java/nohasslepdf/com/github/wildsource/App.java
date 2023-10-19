package nohasslepdf.com.github.wildsource;

import javax.swing.SwingUtilities;

import nohasslepdf.com.github.wildsource.gui.Window;

public class App {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new Window();
		});
	}
}
