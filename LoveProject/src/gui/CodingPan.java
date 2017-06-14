package gui;

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

import code.CMDcompile;
import code.SetBgrImg;
import code.SetChaImg;

public class CodingPan {

	private JPanel mainPane;
	private JLayeredPane lp;
	private SetBgrImg sbi;
	private SetChaImg sci;
	private JTextArea ta;
	private JPanel textPan;
	private String croute;
	private String cfile;
	private String defstr;
	
	public CodingPan() {
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

		lp.setBounds(0, 0, Stat.getFramewidth(), Stat.getFrameheight());
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
		ta.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		ta.setText(SetStr());
		JScrollPane sp = new JScrollPane(ta);
		textPan.add(sp);
		textPan.setOpaque(true);
		textPan.setBounds((Stat.getFramewidth() - 720) / 2, 50, 950, 600);
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
//				else if (check == 1) {
//
//					nextBtn.setText("See Ending!!");
//				}
				else {
					EndingPan ed = new EndingPan();
					PanelChange.convert(ed.getMain());
				}
				check++;
			}
		});
		
		JButton compile = new JButton("Save!");

		compile.setOpaque(true);
		compile.setBounds(110, 330, 100, 100);
		lp.add(compile, JLayeredPane.MODAL_LAYER);
		compile.addActionListener(new ActionListener() {
			boolean status = true;
			public void actionPerformed(ActionEvent e) {

				if (status) {
					FileDialog fd = new FileDialog(LoveFrame.getFrame(), "Save your code!", FileDialog.SAVE);
					fd.setDirectory(".");
					fd.setFile("MyJavaCode.java");
					fd.setVisible(true);

					if (fd.getFile() != null) {
						compile.setText("Compile!");
						croute = fd.getDirectory();
						cfile = fd.getFile();
						status = false;
						//return;
					}
//					croute = fd.getDirectory();
//					cfile = fd.getFile();
					String where = fd.getDirectory() + fd.getFile();

					try {
						BufferedWriter arisu = new BufferedWriter(new FileWriter(where));
						// 버퍼라이터 객체를 통해 TextArea의 내용을 저장
						arisu.write(ta.getText());
						arisu.flush();
						arisu.close();
					} catch (Exception ee) {
						JOptionPane.showMessageDialog(LoveFrame.getFrame(), "Save ERROR");
					}
					//status = false;
				} else {
					CMDcompile cc = new CMDcompile();
					cc.Play(croute, cfile);
					new CodeFrame();
					compile.setText("Save!");
					status = true;
				}
			}
		});
	}
	
	private String SetStr() {
		
		defstr = "public class MyJavaCode {\n"
				+ "	public static void main(String[] args) {\n"
				+ "	//Delete these sentence, ENTER your code here!\n"
				+ "	//Click 'Save' button then you can save your code,\n"
				+ "	//After click 'Compile' button to check error.\n"
				+ "	}\n"
				+ "}";
		
		return defstr;
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

	private void SetCha(String file) {

		sci = null;
		try {
			sci = new SetChaImg(file);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		int ChaH = sci.getImg().getHeight(null);
		int ChaW = sci.getImg().getWidth(null);
		sci.setBounds(60, 110, ChaW, ChaH);
		sci.setOpaque(false);
		lp.add(sci, JLayeredPane.PALETTE_LAYER);
	}
}
