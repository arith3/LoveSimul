package code;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
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

	protected Coding() {
		mainPane = new JPanel();
		lp = new JLayeredPane();
		LayoutSet();
	}

	public JPanel getMain() {
		return mainPane;
	}

	private void LayoutSet() {
		mainPane.setLayout(null);

		SetBgr("./pics/img3.jpg"); // 이거 초기값을 컨스트럭터에서 받게 할까??
		SetCha("./pics/smallkaren.png");

		SetText();
		MakeBtn();
		JLabel tt = new JLabel("Do your code!");
		tt.setBounds(25, 30, 300, 100);
		tt.setFont(new Font("Comic Sans MS", Font.BOLD, 36));
		tt.setForeground(Color.WHITE);
		lp.add(tt, JLayeredPane.PALETTE_LAYER);

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
		ta.setText("Delete these sentence, ENTER your code here!\nWhen you end then click under button.");
		JScrollPane sp = new JScrollPane(ta);
		textPan.add(sp);
		textPan.setOpaque(true);
		textPan.setBounds((Stat.FrameWidth - 720) / 2, 50, 950, 600);
		textPan.setBackground(Color.BLACK);
	}

	private void MakeBtn() {
		JButton nextBtn = new JButton("Finished!!");

		nextBtn.setOpaque(true);
		textPan.add(nextBtn, BorderLayout.SOUTH);
		nextBtn.addActionListener(new ActionListener() {
			int check = 0;

			public void actionPerformed(ActionEvent e) {

				if (check == 0)
					nextBtn.setText("Are you sure? Click one more time.");
				else if (check == 1) {
					FileDialog fd = new FileDialog(LoveFrame.getFrame(), "Save your code", FileDialog.SAVE);

					fd.setDirectory(".");
					fd.setFile("MyJavaCode");
					fd.setVisible(true);

					if (fd.getFile() == null)
						return;

					String where = fd.getDirectory() + fd.getFile() + ".txt";
					// System.out.println(where);

					try {
						BufferedWriter arisu = new BufferedWriter(new FileWriter(where, true));
						// 버퍼라이터 객체를 통해 TextArea의 내용을 저장
						arisu.write(ta.getText());
						arisu.flush();
						arisu.close();

					} catch (Exception ee) {
						JOptionPane.showMessageDialog(LoveFrame.getFrame(), "Save ERROR");
					}
					nextBtn.setText("See Ending!!");
				} else {
					//nextBtn.setText("See Ending!!");
					Ending ed = new Ending();
					PanelChange.convert(ed.getMain());
				}
				check++;
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
		// sbi.repaint();
		lp.add(sbi, JLayeredPane.DEFAULT_LAYER);
		// System.out.println("배경이미지 설정: " + file + sbi.getWidth());
	}

	private void SetCha(String file) {

		sci = null;
		try {
			sci = new SetChaImg(file);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		int ChaH = sci.getImg().getHeight(null);
		// System.out.println(ChaH);
		int ChaW = sci.getImg().getWidth(null);
		// System.out.println(ChaW);

		sci.setBounds(60, 400, ChaW, ChaH);
		sci.setOpaque(false);
		// sci.repaint();
		lp.add(sci, JLayeredPane.PALETTE_LAYER);
	}
}
