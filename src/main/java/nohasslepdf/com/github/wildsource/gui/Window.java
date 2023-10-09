package nohasslepdf.com.github.wildsource.gui;

import javax.swing.JFrame;

import net.miginfocom.swing.MigLayout;

public class Window {
	private JFrame frame;

	public Window() {
		this.frame = new JFrame();
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(640, 480);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new MigLayout());
		frame.setTitle("AC4J");
		frame.setVisible(true);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
