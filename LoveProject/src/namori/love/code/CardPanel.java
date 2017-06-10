package namori.love.code;

import java.awt.CardLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class CardPanel implements KeyListener{

	private CardLayout card;
	private FrameLayout2 fr2;
	private ArrayList<ExamPan> eparr;
	private JPanel cardPan;

	protected CardPanel() {

		card = new CardLayout();
		cardPan = new JPanel(card);
		
		//cardPan.setLayout(card);]
		cardPan.setBounds(0, 0, 1280, 720);
		cardPan.setVisible(true);
		fr2 = new FrameLayout2();
		fr2.setBounds(0, 0, 1280, 720);
		
		cardPan.add(fr2.getMain(), "talk");
		eparr = new ArrayList<ExamPan>();
		for (int i = 0; i < 2; i++) {
			eparr.add(i, new ExamPan(i+1));
			cardPan.add(eparr.get(i).getMain(), "ex"+i);
			//eparr.get(i).getMain().addMouseListener(null);
		} //일단 4번 문제까지 생성함
		
		cardPan.add(fr2.getMain(), "talk");
			
	}

	protected JPanel getCard() {
		return cardPan;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		char c = e.getKeyChar();
		System.out.println("CARD CHANGE??");
		if(c == 'c')
			card.show(cardPan, "talk");
	}

}
