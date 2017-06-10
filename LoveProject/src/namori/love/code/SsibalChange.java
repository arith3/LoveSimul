package namori.love.code;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SsibalChange extends JFrame {
	
	protected void change(JPanel pn, JPanel out)
	{
//		SsibalMotherless.frame.remove(mainPane);
//		SsibalExam ex = new SsibalExam(1);
//		SsibalMotherless.frame.add(ex.getMain());
//		SsibalMotherless.frame.repaint();
		this.remove(pn);
		this.add(out);
		this.repaint();
		
		
		
	}
	
	protected void first(JPanel panel)
	{
		this.add(panel);
	}

}
