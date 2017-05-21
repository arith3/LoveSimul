package namori.love.code;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class FrameBuild {

	
	private JPanel arisuPanel() {
		JPanel pn = new JPanel();

		return pn;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				namoriGUI();
			}
		});
	}///////////////////////////////////////////////////////////////////////////////

	private static void namoriGUI() {

		JFrame frame = new JFrame("Love Simulator");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1200, 800);
		frame.setLocation(360, 140);

		FrameBuild make = new FrameBuild();
		frame.add(make.arisuPanel());

		frame.setVisible(true);
	}
}
