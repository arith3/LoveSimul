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

public class FairyPan {

	private SetBgrImg sbi;
	private SetChaImg sci;
	private JPanel mainPane;
	private JPanel textPan;
	private JLayeredPane lp;
	private JTextArea ta;
	private int chaCnt;
	private int bgrCnt;

	public JPanel getMain() {
		return mainPane;
	}

	public FairyPan() {
		mainPane = new JPanel();
		lp = new JLayeredPane();
		LayoutSet();
	}

	private void LayoutSet() {
		mainPane.setLayout(null);

		SetBgr("./pics/fbg.png");
		SetCha("./pics/kyoko.png");

		SetText();
		MakeBtn();
		lp.setBounds(0, 0, Stat.FrameWidth, Stat.FrameHeight);
		lp.add(textPan, JLayeredPane.MODAL_LAYER);

		lp.setVisible(true);
		mainPane.setVisible(true);
		mainPane.add(lp);
	}

	private void SetBgr(String file) {
		if (bgrCnt != 0)
			lp.remove(sbi);

		sbi = null;
		try {
			sbi = new SetBgrImg(file);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		sbi.setBounds(0, 0, Stat.FrameWidth, Stat.FrameHeight);
		lp.add(sbi, JLayeredPane.DEFAULT_LAYER);
		bgrCnt++;
	}

	private void SetCha(String file) {
		if (chaCnt != 0)
			lp.remove(sci);

		sci = null;
		try {
			sci = new SetChaImg(file);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		int ChaH = sci.getImg().getHeight(null);
		int ChaW = sci.getImg().getWidth(null);

		sci.setBounds((Stat.FrameWidth - ChaW) / 2, (Stat.FrameHeight - ChaH) / 3, ChaW, ChaH);
		sci.setOpaque(false);
		lp.add(sci, JLayeredPane.PALETTE_LAYER);
		chaCnt++;
	}

	private void SetText() {
		textPan = new JPanel();
		textPan.setLayout(new BorderLayout());
		ta = new JTextArea();
		ta.setLineWrap(true);
		ta.setWrapStyleWord(true);
		ta.setFont(new Font("Comic Sans MS", Font.BOLD, 48));
		ta.setText("Hello! I am JAVA Fairy.\nDo you need some tips?");
		JScrollPane sp = new JScrollPane(ta);
		textPan.add(sp);
		textPan.setOpaque(true);
		textPan.setBounds((Stat.FrameWidth - 720) / 2, 500, 720, 180);
		textPan.setBackground(Color.BLACK);
	}

	private void MakeBtn() {
		JButton nextBtn = new JButton("YES!");
		nextBtn.setOpaque(true);
		textPan.add(nextBtn, BorderLayout.EAST);

		nextBtn.addActionListener(new ActionListener() {
			int btncounter = 0;

			public void actionPerformed(ActionEvent e) {

				System.out.println("Change Will be soon");
				if (btncounter == 0) {
					ta.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
					ta.setText("Hints~~~~~~~~~~~~~~~~~~~~~~~~");
					nextBtn.setText("END");
				} else {
					//System.exit(0);
					PanelChange.back();
				}
				btncounter++;
			}
		});
	}

}
