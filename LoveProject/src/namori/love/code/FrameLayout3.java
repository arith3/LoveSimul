package namori.love.code;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class FrameLayout3 extends JPanel {

	private static final long serialVersionUID = 1L;
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

	public FrameLayout3() {
		mainPane = new JPanel();
		lp = new JLayeredPane();
		LayoutSet();
	}

	private void LayoutSet() {
		mainPane.setLayout(null);

		SetBgr("./pics/abcd.jpg"); //�̰� ���߿� ���� Ŭ�������� �ø��� ����
		SetCha("./pics/fairy.png");
		
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
		//sbi.repaint();
		lp.add(sbi, JLayeredPane.DEFAULT_LAYER);

		System.out.println("����̹��� ����: " + file + sbi.getWidth());
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
		System.out.println(ChaH);
		int ChaW = sci.getImg().getWidth(null);
		System.out.println(ChaW);

		sci.setBounds((Stat.FrameWidth - ChaW) / 2, (Stat.FrameHeight - ChaH) / 2, ChaW, ChaH);
		sci.setOpaque(false);
		//sci.repaint();
		lp.add(sci, JLayeredPane.PALETTE_LAYER);
		chaCnt++;
	}

	private void SetText() {
		textPan = new JPanel();
		textPan.setLayout(new BorderLayout());
		ta = new JTextArea();
		ta.setLineWrap(true);
		ta.setWrapStyleWord(true);
		ta.setFont(new Font("Comic Sans MS", Font.BOLD, 42));
		ta.setText("Hello my name is Fairy. Shall we learning about JAVA?");
		JScrollPane sp = new JScrollPane(ta);
		textPan.add(sp);
		textPan.setOpaque(true);
		textPan.setBounds((Stat.FrameWidth - 720) / 2, 500, 720, 180);
		textPan.setBackground(Color.BLACK);
	}

//	private void MakeFairy()
//	{
//		Jbutton fairy = new JButton("Hints");
//		���Ⱑ �ƴ϶� ExamPanŬ������ �߰��ؾ� �ҵ�;
//		
//	}
	
	// ������ ��ư���� ����̶� ĳ���� �ٲٴ°͸� ������.
	private void MakeBtn() {
		JButton nextBtn = new JButton("NEXT");

		nextBtn.setOpaque(true);
		textPan.add(nextBtn, BorderLayout.EAST);
		Person p=new hero();
		p.talking();
		Person pe=new heroine();
		pe.talking();
		
		nextBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// contentPane.setVisible(false); //���� ���������� �Ѿ�� ���� �ڵ�
				System.out.println("Change Will be soon");

				SetBgr("./pics/namae.png");
				SetCha("./pics/karen.png");
				
	            String tmp = p.Dialogue();
	            
	            if (tmp == null) {
		               System.out.println("Heeeeee");
		               ExamPan ep = new ExamPan(1);
		               mainPane.removeAll();
		               mainPane.repaint();
		               mainPane.add(ep.getMain());
		            }
	            else if(tmp.equals("#"))
	            	ta.setText(pe.Dialogue());
	            else
	                ta.setText(tmp);
	            
	            System.out.println(tmp);

				
/*
 * �Լ����� �ڵ�
 * 
 * public void actionPerformed(ActionEvent e) {

            // contentPane.setVisible(false); //���� ���������� �Ѿ�� ���� �ڵ�
            // System.out.println("Change Will be soon");

            String tmp = p.Dialogue();
            ta.setText(tmp);
            System.out.println(tmp);
            if (tmp == null) {
               System.out.println("Heeeeee");
               ExamPan ep = new ExamPan(1);
               mainPane.removeAll();
               mainPane.repaint();
               mainPane.add(ep.getMain());

            }
         }
 * 
 * p�� ��ü������ ���� ���ؼ� �������µ� ������ �ϴ°����� �˾Ƽ� �о�ͺ�.
 * 
 */
				
				//mainPane.removeAll();
				//mainPane.setVisible(false);
			}
		});
	}
}
