package namori.love.code;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrameLayout extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameLayout frame = new FrameLayout();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrameLayout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 920, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel CharicPan = new JPanel();
		CharicPan.setBounds(215, 5, 474, 552);
		//CharicPan.setBackground(new Color(255,0,0,0)); // 투명한 패널 만드는 방법: new Color(~)
		CharicPan.setOpaque(true);
		
		JPanel TalkPan = new JPanel();
		//TalkPan.setBackground(new Color(100,255,255,255));
		TalkPan.setOpaque(true);
		TalkPan.setBounds(66, 417, 783, 118);
		
		JPanel TempCha = new JPanel();
		TempCha.setBackground(Color.GREEN);
		GroupLayout gl_CharicPan = new GroupLayout(CharicPan);
		gl_CharicPan.setHorizontalGroup(
			gl_CharicPan.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_CharicPan.createSequentialGroup()
					.addGap(47)
					.addComponent(TempCha, GroupLayout.PREFERRED_SIZE, 374, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(53, Short.MAX_VALUE))
		);
		gl_CharicPan.setVerticalGroup(
			gl_CharicPan.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_CharicPan.createSequentialGroup()
					.addContainerGap(60, Short.MAX_VALUE)
					.addComponent(TempCha, GroupLayout.PREFERRED_SIZE, 456, GroupLayout.PREFERRED_SIZE)
					.addGap(36))
		);
		CharicPan.setLayout(gl_CharicPan);
		contentPane.setLayout(null);
		contentPane.add(TalkPan);
		
		JPanel ButnPan = new JPanel();
		GroupLayout gl_TalkPan = new GroupLayout(TalkPan);
		gl_TalkPan.setHorizontalGroup(
			gl_TalkPan.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_TalkPan.createSequentialGroup()
					.addContainerGap(740, Short.MAX_VALUE)
					.addComponent(ButnPan, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
		);
		gl_TalkPan.setVerticalGroup(
			gl_TalkPan.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_TalkPan.createSequentialGroup()
					.addContainerGap(86, Short.MAX_VALUE)
					.addComponent(ButnPan, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
		);
		
		JButton NextBtn = new JButton("New button");
		NextBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TempCha.setBackground(Color.RED);
				
			}
		});
		NextBtn.setForeground(Color.PINK);
		NextBtn.setBackground(Color.PINK);
		NextBtn.setOpaque(true);
		ButnPan.add(NextBtn);
		TalkPan.setLayout(gl_TalkPan);
		contentPane.add(CharicPan);
	}
}
