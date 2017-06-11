package code;

import javax.swing.JPanel;

public class SsibalChange {
	
	protected static void change(JPanel out)
	{
//		SsibalMotherless.frame.remove(mainPane);
//		SsibalExam ex = new SsibalExam(1);
//		SsibalMotherless.frame.add(ex.getMain());
//		SsibalMotherless.frame.repaint();

		SsibalMotherless.getFrame().removeAll();
		SsibalMotherless.getFrame().add(out);
		SsibalMotherless.getFrame().repaint();
	}
	

}
