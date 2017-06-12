package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;

/*
 * This class is main.
 * Make a static frame and thread.
 * Coded by namori.
 */

public class LoveFrame {

	private static JFrame frame;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					arisuFrame();
				} catch (Exception e) {
					System.out.println("Error!! Error!! Error!!");
					e.printStackTrace();
				}
			}
		});
	}
	
	private static void arisuFrame()
	{
		frame = new JFrame("♥ Love Simulator ♥");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(Stat.getFramewidth(), Stat.getFrameheight());
		frame.setResizable(false);
		frame.setLocation(100, 100);
		
		
//		TalkPan fl = new TalkPan();
//		frame.add(fl.getMain());
		new IntroPan();
//		FairyPan fp = new FairyPan();
//		frame.add(fp.getMain());
		

		//여기서 객체 만들면서 추가하면 될듯?
		//내 생각엔 패널 하나 더 만들어서 이 클래스에선 그 패널 출력만 하고 거기서 바꾸자

		

		frame.setVisible(true);
	}
	
	protected static JFrame getFrame() {
		return frame;
	}
}