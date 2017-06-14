package gui;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import code.SetBgrImg;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

/*
 * This class show ending by status.
 * Coded by namori.
 */

public class EndingPan {

	private SetBgrImg sbi;
	private JPanel mainPane;
	private JPanel textPan;
	private JLayeredPane lp;
	private JTextArea ta;
	private boolean end;

	public JPanel getMain() {
		return mainPane;
	}

	public EndingPan() {
		mainPane = new JPanel();
		lp = new JLayeredPane();
		end = Success();
		LayoutSet();
	}

	private boolean Success() {
		if (Stat.getScore() >= 8.0)
			return true;
		else
			return false;
	}

	private void LayoutSet() {
		mainPane.setLayout(null);

		SetBgr("./pics/img1.jpg"); // 이거 초기값을 컨스트럭터에서 받게 할까??

		SetText();
		MakeBtn();

		lp.setBounds(0, 0, Stat.getFramewidth(), Stat.getFrameheight());
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

		sbi.setBounds(0, 0, Stat.getFramewidth(), Stat.getFrameheight());
		lp.add(sbi, JLayeredPane.DEFAULT_LAYER);
	}

	private void SetText() {
		textPan = new JPanel();
		textPan.setLayout(new BorderLayout());
		ta = new JTextArea();
		ta.setEditable(false);
		ta.setLineWrap(true);
		ta.setWrapStyleWord(true);
		ta.setFont(new Font("Comic Sans MS", Font.BOLD, 32));
		ta.setText("Coding after 3 months later...");
		textPan.add(ta);
		textPan.setOpaque(true);
		textPan.setBounds(640, 600, 600, 60);
	}

	private void MakeBtn() {
		JButton nextBtn = new JButton("NEXT");

		nextBtn.setOpaque(true);
		textPan.add(nextBtn, BorderLayout.EAST);

		nextBtn.addActionListener(new ActionListener() {
			int sysend = 0;

			public void actionPerformed(ActionEvent e) {
				if (sysend == 0) {
					lp.remove(sbi);
					if (end) {
						SetBgr("./pics/good.png");
						ta.setText("Now she is my girlfriend.");
						nextBtn.setText("Happy");
					} else {
						SetBgr("./pics/bad.png");
						textPan.setBounds(600, 600, 640, 60);
						ta.setText("She is sick because I am useless.");
						nextBtn.setText("Sad");
					}
				}
				if (sysend == 1)
					nextBtn.setText("END");
				if (sysend == 2)
					System.exit(0);
				sysend++;
			}
		});
	}
}
