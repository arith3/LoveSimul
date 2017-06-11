package code;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
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

public class Ending {

	private SetBgrImg sbi;
	private JPanel mainPane;
	private JPanel textPan;
	private JLayeredPane lp;
	private JTextArea ta;
	private boolean end;
	
	public JPanel getMain() {
		return mainPane;
	}

	public Ending() {
		mainPane = new JPanel();
		lp = new JLayeredPane();
		end = Success();
		LayoutSet();
	}
	
	private boolean Success()
	{
		if(Stat.getScore() >= 8.0)
			return true;
		else
			return false;
	}

	private void LayoutSet() {
		mainPane.setLayout(null);

		SetBgr("./pics/abcd.jpg"); //이거 초기값을 컨스트럭터에서 받게 할까??
		
		if(end)
		{
			SetBgr("./pics/good.png");
			
		}
		else
		{
			SetBgr("./pics/bad.png");
			
		}
		
		
		SetText();
		MakeBtn();
		
		
		lp.setBounds(0, 0, Stat.FrameWidth, Stat.FrameHeight);
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
		ta.setText("3 months later...");
		textPan.add(ta);
		textPan.setOpaque(true);
		textPan.setBounds((Stat.FrameWidth - 720) / 2, 500, 720, 180);
	}

	private void MakeBtn() {
		JButton nextBtn = new JButton("NEXT");

		nextBtn.setOpaque(true);
		textPan.add(nextBtn, BorderLayout.EAST);
		
		nextBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
	}
}
