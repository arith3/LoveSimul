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

public class FrameLayout2 extends JPanel {

	private static final long serialVersionUID = 1L;
	// private JPanel contentPane;
	SetBgrImg sbi;
	SetChaImg sci;
	JPanel mainPane;
	JPanel bgrPan;
	JPanel chaPan;
	JPanel textPan;
	JLayeredPane lp;

	public JPanel getMain() {
		return mainPane;
	}

	public FrameLayout2() {
		mainPane = new JPanel();
		bgrPan = new JPanel();
		chaPan = new JPanel();
		lp = new JLayeredPane();
		LayoutSet();
		// getContentPane().add(mainPane);
	}

	private void LayoutSet() {
		//mainPane.setBounds(0, 0, Stat.FrameWidth, Stat.FrameHeight);
		mainPane.setBackground(Color.RED);
		// mainPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		mainPane.setLayout(null);
		bgrPan.setBounds(0, 0, Stat.FrameWidth, Stat.FrameHeight);

		SetBgr("abcd.jpg");
		SetCha("kyoko.png");
		SetText();
		MakeBtn();
		lp.setBounds(0, 0, Stat.FrameWidth, Stat.FrameHeight);
		lp.add(bgrPan, JLayeredPane.DEFAULT_LAYER);
		lp.add(chaPan, JLayeredPane.PALETTE_LAYER);
		lp.add(textPan, JLayeredPane.MODAL_LAYER);

		lp.setVisible(true);
		mainPane.setVisible(true);
		mainPane.add(lp);
	}

	private void SetBgr(String file) {
		sbi = null;
		try {
			sbi = new SetBgrImg(file);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		sbi.setBounds(0, 0, Stat.FrameWidth, Stat.FrameHeight);
		bgrPan.add(sbi);
		bgrPan.repaint();
		System.out.println("배경이미지 설정: " + file + sbi.getWidth());
	}

	private void SetCha(String file) {
		sci = null;
		try {
			sci = new SetChaImg(file);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		int ChaH = sci.getImg().getHeight(null);
		System.out.println(ChaH);
		int ChaW = sci.getImg().getWidth(null);
		System.out.println(ChaW);
		sci.setBounds(0, 0, ChaH, ChaW);
		sci.setOpaque(false);

		chaPan.setBounds((Stat.FrameWidth - ChaW) / 2, (Stat.FrameHeight - ChaH) / 2, ChaW, ChaH);
		chaPan.setOpaque(false);
		chaPan.setVisible(true);
		chaPan.add(sci);
	}

	private void SetText() {
		textPan = new JPanel();

		textPan.setOpaque(true);
		textPan.setBounds(200, 497, 863, 174);
		textPan.setBackground(Color.BLACK);

		// mainPane.add(textPan);
	}

	private void MakeBtn() {
		JButton nextBtn = new JButton("NEXT");

		nextBtn.setBounds(600, 100, 50, 50);
		nextBtn.setForeground(Color.PINK);
		nextBtn.setBackground(Color.PINK);
		nextBtn.setOpaque(true);
		textPan.add(nextBtn);
		nextBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// contentPane.setVisible(false); //다음 프레임으로 넘어가기 위한 코드
				System.out.println("asdasdasfasd"); // invisible했을때 버튼이 남아있는지
													// 체크하는 코드
				// LoveFrame.page = 4; //실험중

				// ExamPan ep = new ExamPan();
				//
				// contentPane.removeAll();
				// contentPane.add(ep.pan);
				// contentPane.setVisible(true);

				SetBgr("namae.png");
				SetCha("karen.png");
				// getContentPane().repaint();
			}
		});
	}
}
