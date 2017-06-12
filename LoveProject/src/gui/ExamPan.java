package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import code.Exams;
import code.SetBgrImg;
import code.SetChaImg;

/*
 * This class is exam that has constructor need integer.
 * The integer is number of exam.
 * Has Exams class what call text by text files.
 * Coded by namori.
 */

public class ExamPan extends MouseAdapter
{
	private JPanel mainp;
	private JPanel prop; //문제패널
	private JPanel chop1; //선택지패널
	private JPanel chop2; //선택지패널
	private JPanel chop3; //선택지패널
	private JPanel chop4; //선택지패널
	private JPanel faip;
	private JButton cho1;
	private JButton cho2;
	private JButton cho3;
	private JButton cho4;
	private JButton btnCallFairy;
	private JLayeredPane lp;
	private SetBgrImg sbi;
	private SetChaImg sci;
	private Exams ex;
	private JLabel result;
	private boolean fairycalled = false;
	
	public ExamPan(int number)
	{
		ex = new Exams(number);
		mainp = new JPanel();
		mainp.setSize(Stat.getFramewidth(), Stat.getFrameheight());
		mainp.setLayout(null);
		
		makePane();
		SetBgr("./pics/img2.jpg");
		SetCha("./pics/karen.png");

		mainp.setVisible(true);
	}
	
	public JPanel getMain()
	{
		return mainp;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		int btnnum = 0;
		if (e.getSource().equals(cho1)) {
			btnnum = 1;
			cho1.setEnabled(false);
		}
		if (e.getSource().equals(cho2)) {
			btnnum = 2;
			cho2.setEnabled(false);
		}
		if (e.getSource().equals(cho3)) {
			btnnum = 3;
			cho3.setEnabled(false);
		}
		if (e.getSource().equals(cho4)) {
			btnnum = 4;
			cho4.setEnabled(false);
		}
		if (e.getSource().equals(btnCallFairy))
			btnnum = 5;

		if (btnnum == ex.getAnswer()) {
			System.out.println("You're right!");
			result.setForeground(Color.GREEN);
			result.setText("TRUE!!");

			// try {
			// Thread.sleep(1000);
			// } catch (InterruptedException e1) {
			// // TODO Auto-generated catch block
			// e1.printStackTrace();
			// }

			// int result = JOptionPane.showConfirmDialog(mainp, "Are you sure
			// you want to exit?", "Exiting", JOptionPane.OK_OPTION);
			// lp.add(new JPanel(), JOptionPane.showConfirmDialog(mainp, "Are
			// you sure you want to exit?", "Exiting", JOptionPane.OK_OPTION),
			// JLayeredPane.DRAG_LAYER);
			// if (result == JOptionPane.OK_OPTION) {
			// System.exit(0);
			// }
			// mainp.repaint();

//			TalkPan tp = new TalkPan();
//			PanelChange.convert(tp.getMain());
//			FairyPan fp = new FairyPan();
//			PanelChange.convert(fp.getMain());
			if(fairycalled)
				PanelChange.backback();
			else
				PanelChange.back();
		} else if (btnnum == 5) {
			FairyPan fp = new FairyPan();
			PanelChange.convert(fp.getMain());
			fairycalled = true;
		} else {
			System.out.println("You're wrong!");
			Stat.minusScore();
			result.setForeground(Color.RED);
			result.setText("FALSE!!");
		}
	}

	private void makePane()
	{
		lp = new JLayeredPane();
		prop = new JPanel();
		chop1 = new JPanel();
		chop2 = new JPanel();
		chop3 = new JPanel();
		chop4 = new JPanel();
		faip = new JPanel();
		
		prop.setBounds(250, 100, 950, 60);
		//prop.setOpaque(false);
		JLabel lb = new JLabel();
		lb.setFont(new Font("Verdana", Font.BOLD, 36));
		lb.setText(ex.getProblem());
		prop.add(lb);
		
		chop1.setBounds(600, 230, 600, 80);
		cho1 = new JButton();
		cho1.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		cho1.addMouseListener(this);
		chop1.setLayout(new BorderLayout());
		cho1.setText(ex.getChoice().get(0));
		chop1.add(cho1, BorderLayout.CENTER);
		
		chop2.setBounds(600, 340, 600, 80);
		cho2 = new JButton();
		cho2.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		cho2.addMouseListener(this);
		chop2.setLayout(new BorderLayout());
		cho2.setText(ex.getChoice().get(1));
		chop2.add(cho2, BorderLayout.CENTER);
		
		chop3.setBounds(600, 450, 600, 80);
		cho3 = new JButton();
		cho3.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		cho3.addMouseListener(this);
		chop3.setLayout(new BorderLayout());
		cho3.setText(ex.getChoice().get(2));
		chop3.add(cho3, BorderLayout.CENTER);
		
		chop4.setBounds(600, 560, 600, 80);
		cho4 = new JButton();
		cho4.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		cho4.addMouseListener(this);
		chop4.setLayout(new BorderLayout());
		cho4.setText(ex.getChoice().get(3));
		chop4.add(cho4, BorderLayout.CENTER);
		
		faip.setBounds(15, 15, 90, 25);
		btnCallFairy = new JButton("Call Fairy!");
		//btnCallFairy.setBounds(15, 15, 90, 25);
		btnCallFairy.addMouseListener(this);
		faip.setLayout(new BorderLayout());
		faip.add(btnCallFairy, BorderLayout.CENTER);
		
		result = new JLabel("");
		result.setText("Solve it!");
		result.setFont(new Font("Comic Sans MS", Font.BOLD, 80));
		result.setForeground(Color.BLACK);
		result.setBounds(73, 115, 324, 200);
		lp.add(result, JLayeredPane.PALETTE_LAYER);
		
		lp.setBounds(0, 0, Stat.getFramewidth(), Stat.getFrameheight());
		lp.add(chop1, JLayeredPane.PALETTE_LAYER);
		lp.add(chop2, JLayeredPane.PALETTE_LAYER);
		lp.add(chop3, JLayeredPane.PALETTE_LAYER);
		lp.add(chop4, JLayeredPane.PALETTE_LAYER);
		lp.add(faip, JLayeredPane.PALETTE_LAYER);
		lp.add(prop, JLayeredPane.PALETTE_LAYER);
		lp.setVisible(true);
		mainp.add(lp);
	}
	
	private void SetCha(String file) {
		sci = null;
		try {
			sci = new SetChaImg(file);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		int ChaH = sci.getImg().getHeight(null);
		//System.out.println(ChaH);
		int ChaW = sci.getImg().getWidth(null);
		//System.out.println(ChaW);

		sci.setBounds((Stat.getFramewidth() - ChaW) / 8, (Stat.getFrameheight() - ChaH), ChaW, ChaH);
		sci.setOpaque(false);
		lp.add(sci, JLayeredPane.PALETTE_LAYER);
	}
	
	private void SetBgr(String file) {
		sbi = null;
		try {
			sbi = new SetBgrImg(file);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		sbi.setBounds(0, 0, Stat.getFramewidth(), Stat.getFrameheight());
		//sbi.repaint();
		lp.add(sbi, JLayeredPane.DEFAULT_LAYER);

		//System.out.println("배경이미지 설정: " + file + sbi.getWidth());
	}
}