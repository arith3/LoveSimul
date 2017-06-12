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
		frame = new JFrame("�� Love Simulator ��");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(Stat.getFramewidth(), Stat.getFrameheight());
		frame.setResizable(false);
		frame.setLocation(100, 100);
		
		
//		TalkPan fl = new TalkPan();
//		frame.add(fl.getMain());
		new IntroPan();
//		FairyPan fp = new FairyPan();
//		frame.add(fp.getMain());
		

		//���⼭ ��ü ����鼭 �߰��ϸ� �ɵ�?
		//�� ������ �г� �ϳ� �� ���� �� Ŭ�������� �� �г� ��¸� �ϰ� �ű⼭ �ٲ���

		

		frame.setVisible(true);
	}
	
	protected static JFrame getFrame() {
		return frame;
	}
}