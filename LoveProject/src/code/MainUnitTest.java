package code;

import java.awt.EventQueue;

import javax.swing.JFrame;

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
		frame.setSize(Stat.FrameWidth, Stat.FrameHeight);
		frame.setResizable(false);
		frame.setLocation(100, 100);
		
		
		Coding c = new Coding();
		frame.add(c.getMain());
//		Ending e = new Ending();
//		frame.add(e.getMain());
//		

		frame.setVisible(true);
	}
	
	protected static JFrame getFrame() {
		return frame;
	}
}
