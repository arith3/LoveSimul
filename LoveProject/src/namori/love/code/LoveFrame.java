package namori.love.code;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class LoveFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	//protected static int page;
	
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
		frame.setSize(Stat.FrameWidth, Stat.FrameHeight);
		frame.setResizable(false);
		frame.setLocation(100, 100);
		
		
		FrameLayout2 fl = new FrameLayout2();
		
		frame.add(fl.getMain());
		
		
//		FrLy3 f = new FrLy3();
//		frame.add(f.getContentPane());
		//여기서 객체 만들면서 추가하면 될듯?
		//내 생각엔 패널 하나 더 만들어서 이 클래스에선 그 패널 출력만 하고 거기서 바꾸자

		

		frame.setVisible(true);
	}
	
	
}