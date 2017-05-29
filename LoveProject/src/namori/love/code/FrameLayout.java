package namori.love.code;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;


public class FrameLayout extends JFrame {

	private static final long serialVersionUID = 1L;
	protected static final int FrameWidth = 1280;
	protected static final int FrameHeight = 720;
	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FrameLayout frame = new FrameLayout();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					System.out.println("Error!! Error!! Error!!");
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public FrameLayout() {
		setTitle("♥ Love Simulator ♥");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, FrameWidth, FrameHeight);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel CharicPan = new JPanel();

		SetChaImg sci = null;
		try {
			sci = new SetChaImg("kyoko.png");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int ChaH = sci.getImg().getHeight(null);
		System.out.println(ChaH);
		int ChaW = sci.getImg().getWidth(null);
		System.out.println(ChaW);
		sci.setBounds(0, 0, ChaH, ChaW);
		sci.setOpaque(false);
	
		CharicPan.setBounds((FrameWidth - ChaW) / 2, (FrameHeight - ChaH) / 2, ChaW, ChaH);
		//CharicPan.setBackground(new Color(255, 0, 0, 0)); // 투명한 패널 만드는 방법: new
															// Color(~)
		CharicPan.setOpaque(false);
		CharicPan.add(sci);
		

		JPanel TalkPan = new JPanel();
		// TalkPan.setBackground(new Color(100,255,255,255));
		TalkPan.setOpaque(true);
		TalkPan.setBounds(200, 497, 863, 174);
		GroupLayout gl_CharicPan = new GroupLayout(CharicPan);
		gl_CharicPan.setHorizontalGroup(
				gl_CharicPan.createParallelGroup(Alignment.LEADING).addGap(0, 474, Short.MAX_VALUE));
		gl_CharicPan
				.setVerticalGroup(gl_CharicPan.createParallelGroup(Alignment.TRAILING).addGap(0, 552, Short.MAX_VALUE));
		CharicPan.setLayout(gl_CharicPan);
		contentPane.setLayout(null);
		contentPane.add(TalkPan);

		JPanel ButnPan = new JPanel();
		//TalkSpace ts = new TalkSpace();
		//TalkPan.add(ts.getTa());
		GroupLayout gl_TalkPan = new GroupLayout(TalkPan);
		gl_TalkPan.setHorizontalGroup(
			gl_TalkPan.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_TalkPan.createSequentialGroup()
					.addContainerGap(740, Short.MAX_VALUE)
					.addComponent(ButnPan, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
		);
		gl_TalkPan.setVerticalGroup(
			gl_TalkPan.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_TalkPan.createSequentialGroup()
					.addGap(85)
					.addComponent(ButnPan, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);

		JButton NextBtn = new JButton("New button");
		NextBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TalkPan.setBackground(Color.RED);
				JLabel lblb = new JLabel("코드조까치도 짜네");
				TalkPan.add(lblb);
			}
		});
		NextBtn.setForeground(Color.PINK);
		NextBtn.setBackground(Color.PINK);
		NextBtn.setOpaque(true);
		ButnPan.add(NextBtn);
		TalkPan.setLayout(gl_TalkPan);
		contentPane.add(CharicPan);

		SetBgrImg sbi = null;
		try {
			sbi = new SetBgrImg("namae.png");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// this.add(sbi);
		sbi.setBounds(0, 0, FrameWidth, FrameHeight);
		getContentPane().add(sbi);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 10, 10);
		contentPane.add(panel);
	}
}
