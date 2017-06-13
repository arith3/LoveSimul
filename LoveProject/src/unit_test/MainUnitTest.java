package unit_test;

import java.awt.EventQueue;

import javax.swing.JFrame;

import gui.CodingPan;
import gui.Stat;

public class MainUnitTest {

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
		frame = new JFrame("¢¾ Love Simulator ¢¾");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(Stat.getFramewidth(), Stat.getFrameheight());
		frame.setResizable(false);
		frame.setLocation(100, 100);
		
		CodingPan co = new CodingPan();
		frame.add(co.getMain());
//		

		frame.setVisible(true);
	}
	
	protected static JFrame getFrame() {
		return frame;
	}
}
