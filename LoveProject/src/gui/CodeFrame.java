package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class CodeFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextArea ta;
	private JPanel textPan;

	public CodeFrame() {
		setTitle("Show your code ERROR");
		setSize(640, 360);
		setLocation(300, 320);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		SetText();

		getContentPane().add(textPan);

		setVisible(true);
	}

	private void SetText() {
		textPan = new JPanel();
		textPan.setBounds(0, 0, 640, 360);
		textPan.setLayout(new BorderLayout());
		ta = new JTextArea();
		ta.setEditable(false);
		ta.setLineWrap(true);
		ta.setWrapStyleWord(true);
		ta.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
		//ta.setText("Hello my name is Fairy.\nDo you know how to PLAY?\nPress NEXT button rightside.");
		ta.setText(ErrMsg());
		if(ErrMsg() == "") {
			ta.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
			ta.setText("Well done!!\nError did not occured!!");
		}
		else
			ta.setText(ErrMsg());
		JScrollPane sp = new JScrollPane(ta);
		textPan.add(sp);
		textPan.setOpaque(true);
	}

	private String ErrMsg() {
		String compare = "";

		int len = Stat.getMSG().size();
		for (int i = 0; i < len; i++) {
			compare = compare + "\n" + Stat.getMSG().get(i);
		}

		return compare;
	}
}
