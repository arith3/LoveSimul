package namori.love.code;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

public class CardPanel {

	private CardLayout card;
	private SsibalFrame fr2;
	private JPanel cardPan;

	protected CardPanel() {

		card = new CardLayout(0, 0);
		cardPan = new JPanel();
		cardPan.setLayout(card);
		cardPan.setBounds(0,0,1280,720);
		
		
		fr2 = new SsibalFrame();
		cardPan.add(fr2, "temp");

		for (int i = 0; i < 5; i++) {
			JPanel temp = new ExamPan(i+1).getMain();
			temp.setVisible(true);
			temp.setSize(1280, 720);
			cardPan.add(temp, "ex"+i);
		}
		
		
		cardPan.setVisible(true);
		cardPan.repaint();
	}

	protected JPanel getCard() {
		return cardPan;
	}
}
