package code;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Coding {

	private JPanel mainPane;
	private JLayeredPane lp;
	private SetBgrImg sbi;
	private SetChaImg sci;
	private JTextArea ta;
	private JPanel textPan;
	
	protected Coding()
	{
		mainPane = new JPanel();
		lp = new JLayeredPane();
		LayoutSet();
	}
	
	public JPanel getMain()
	{
		return mainPane;
	}
	
	private void LayoutSet() {
		mainPane.setLayout(null);

		SetBgr("./pics/abcd.jpg"); //�̰� �ʱⰪ�� ����Ʈ���Ϳ��� �ް� �ұ�??
		SetCha("./pics/smallkaren.png");
		
		SetText();
		MakeBtn();
		lp.setBounds(0, 0, Stat.FrameWidth, Stat.FrameHeight);
		lp.add(textPan, JLayeredPane.MODAL_LAYER);

		lp.setVisible(true);
		mainPane.setVisible(true);
		mainPane.add(lp);
	}
	
	private void SetText() {
		textPan = new JPanel();
		textPan.setLayout(new BorderLayout());
		ta = new JTextArea();
		ta.setLineWrap(true);
		ta.setWrapStyleWord(true);
		ta.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		ta.setText("Delete this sentence, ENTER your code here!\nWhen you end then click under button.");
		JScrollPane sp = new JScrollPane(ta);
		textPan.add(sp);
		textPan.setOpaque(true);
		textPan.setBounds((Stat.FrameWidth - 720) / 2, 500, 720, 180);
		textPan.setBackground(Color.BLACK);
	}
	
	private void MakeBtn() {
		JButton nextBtn = new JButton("Finished!!");

		nextBtn.setOpaque(true);
		textPan.add(nextBtn, BorderLayout.SOUTH);	
		nextBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
	}
	
	private void SetBgr(String file) {

		sbi = null;
		try {
			sbi = new SetBgrImg(file);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		sbi.setBounds(0, 0, Stat.FrameWidth, Stat.FrameHeight);
		//sbi.repaint();
		lp.add(sbi, JLayeredPane.DEFAULT_LAYER);
		//System.out.println("����̹��� ����: " + file + sbi.getWidth());
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

		sci.setBounds((Stat.FrameWidth - ChaW) / 2, (Stat.FrameHeight - ChaH) / 3, ChaW, ChaH);
		sci.setOpaque(false);
		//sci.repaint();
		lp.add(sci, JLayeredPane.PALETTE_LAYER);
	}
}
