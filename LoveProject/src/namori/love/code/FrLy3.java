package namori.love.code;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;


public class FrLy3 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	SetBgrImg sbi;
	JPanel BgPan;
	JLayeredPane lp = new JLayeredPane();
	private SetChaImg sci_1;

	public FrLy3() {
		setTitle("♥ Love Simulator ♥");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, Stat.FrameWidth, Stat.FrameHeight);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel CharicPan = new JPanel();
		BgPan = new JPanel();

		lp.add(BgPan, new Integer(0));
		lp.add(CharicPan, new Integer(1));
		lp.setBounds(0,0,1280,720);
		//lp.setVisible(false);
		contentPane.add(lp);
		
		SetChaImg sci = null;
		try {
			sci_1 = new SetChaImg("karen.png");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int ChaH = sci_1.getImg().getHeight(null);
		System.out.println(ChaH);
		int ChaW = sci_1.getImg().getWidth(null);
		System.out.println(ChaW);
		sci_1.setBounds(0, 0, 0, 0);
		sci_1.setOpaque(false);
	
		CharicPan.setBounds((Stat.FrameWidth - ChaW) / 2, (Stat.FrameHeight - ChaH) / 2, ChaW, ChaH);
		//CharicPan.setBackground(new Color(255, 0, 0, 0)); // 투명한 패널 만드는 방법: new
															// Color(~)
		CharicPan.setOpaque(false);
		CharicPan.add(sci_1);
		
		BgPan.setBounds(0, 0, Stat.FrameWidth, Stat.FrameHeight);
		//BgPan.setOpaque(false);
		
		

		JPanel TalkPan = new JPanel();
		TalkPan.setBounds(200, 497, 863, 174);
		CharicPan.setLayout(null);
		CharicPan.add(sci_1);
		contentPane.setLayout(null);
		contentPane.add(TalkPan);

		JPanel ButnPan = new JPanel();
		ButnPan.setBounds(820, 85, 43, 32);

		JButton NextBtn = new JButton("NEXT");
		NextBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				//contentPane.setVisible(false);  //다음 프레임으로 넘어가기 위한 코드
				System.out.println("asdasdasfasd"); //invisible했을때 버튼이 남아있는지 체크하는 코드
				//LoveFrame.page = 4;  //실험중
				
//				ExamPan ep = new ExamPan();
//				
//				contentPane.removeAll();
//				contentPane.add(ep.pan);
//				contentPane.setVisible(true);
				
				SetBg("pgs.jpg");
				//getContentPane().repaint();
			}
		});
		TalkPan.setLayout(null);
		
		
		NextBtn.setForeground(Color.PINK);
		NextBtn.setBackground(Color.PINK);
		NextBtn.setOpaque(true);
		ButnPan.add(NextBtn);
		TalkPan.add(ButnPan);
		//contentPane.add(CharicPan);  //레이어패널 테스트용!!!
		//contentPane.add(BgPan);

//		SetBgrImg sbi = null;
//		try {
//			sbi = new SetBgrImg("namae.png");
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		sbi.setBounds(0, 0, Stat.FrameWidth, Stat.FrameHeight);
//		getContentPane().add(sbi);
		
		SetBg("abcd.jpg");
		//SetBg("namae.png");
		
		

	}
	
	
	private void SetBg(String file)
	{
		SetBgrImg sbi = null;
		try {
			sbi = new SetBgrImg(file);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		//getContentPane().removeAll();
		sbi.setBounds(0, 0, Stat.FrameWidth, Stat.FrameHeight);
		//getContentPane().add(sbi);
		//getContentPane().repaint();
		BgPan.add(sbi);
		BgPan.repaint();
		System.out.println("배경이미지 설정: "+file+sbi.getWidth());
		
	}
}
