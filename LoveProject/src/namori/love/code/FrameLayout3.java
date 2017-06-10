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

		SetBgr("./pics/abcd.jpg"); //이건 나중에 지하 클래스에서 올리게 하자
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

		System.out.println("배경이미지 설정: " + file + sbi.getWidth());
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
//		여기가 아니라 ExamPan클래스에 추가해야 할듯;
//		
//	}
	
	// 지금은 버튼으로 배경이랑 캐릭터 바꾸는것만 구현함.
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

				// contentPane.setVisible(false); //다음 프레임으로 넘어가기 위한 코드
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
 * 규석이의 코드
 * 
 * public void actionPerformed(ActionEvent e) {

            // contentPane.setVisible(false); //다음 프레임으로 넘어가기 위한 코드
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
 * p를 객체생성을 아직 안해서 오류나는데 위에서 하는가보네 알아서 읽어와봐.
 * 
 */
				
				//mainPane.removeAll();
				//mainPane.setVisible(false);
			}
		});
	}
}
