package namori.love.code;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class LoveFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final int FrameWidth = 1280;
	private static final int FrameHeight = 720;
	
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
		JFrame frame = new JFrame("♥ Love Simulator ♥");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(FrameWidth, FrameHeight);
		frame.setLocation(100, 100);
		

		FrameLayout fl = new FrameLayout();
		
		frame.add(fl.getContentPane());
		//여기서 객체 만들면서 추가하면 될듯?
		//내 생각엔 패널 하나 더 만들어서 이 클래스에선 그 패널 출력만 하고 거기서 바꾸자
		
		

		frame.setVisible(true);
	}
	
	
}