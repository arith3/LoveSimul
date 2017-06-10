package namori.love.code;

import javax.swing.JFrame;

public class CardTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame frame = new JFrame("¢¾ Love Simulator ¢¾");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(Stat.FrameWidth, Stat.FrameHeight);
		frame.setResizable(false);
		frame.setLocation(100, 100);
		frame.setVisible(true);
		frame.setLayout(null);
		
		CardPanel cp = new CardPanel();
		
		frame.add(cp.getCard());
		
	}

}
