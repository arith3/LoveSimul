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
		JFrame frame = new JFrame("�� Love Simulator ��");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(FrameWidth, FrameHeight);
		frame.setLocation(100, 100);
		

		FrameLayout fl = new FrameLayout();
		
		frame.add(fl.getContentPane());
		//���⼭ ��ü ����鼭 �߰��ϸ� �ɵ�?
		//�� ������ �г� �ϳ� �� ���� �� Ŭ�������� �� �г� ��¸� �ϰ� �ű⼭ �ٲ���
		
		

		frame.setVisible(true);
	}
	
	
}