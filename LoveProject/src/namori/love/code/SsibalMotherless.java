package namori.love.code;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class SsibalMotherless {

	public static JFrame frame;
	
	
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
		frame.setSize(Stat.FrameWidth, Stat.FrameHeight);
		frame.setResizable(false);
		frame.setLocation(100, 100);
		
		SsibalFrame sp = new SsibalFrame();
		frame.add(sp.getMain());
		
		
//		FrameLayout3 fl = new FrameLayout3();
//		
//		frame.add(fl.getMain());
//		
//		ExamPan ep = new ExamPan(1);
//		frame.add(ep.getMain());
//		FrLy3 f = new FrLy3();
//		frame.add(f.getContentPane());
		//���⼭ ��ü ����鼭 �߰��ϸ� �ɵ�?
		//�� ������ �г� �ϳ� �� ���� �� Ŭ�������� �� �г� ��¸� �ϰ� �ű⼭ �ٲ���

		

		frame.setVisible(true);
	}
}
