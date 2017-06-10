package code;

import javax.swing.JPanel;

public class SsibalChange {
	
	protected static void change(JPanel out)
	{
//		SsibalMotherless.frame.remove(mainPane);
//		SsibalExam ex = new SsibalExam(1);
//		SsibalMotherless.frame.add(ex.getMain());
//		SsibalMotherless.frame.repaint();

		SsibalMotherless.frame.removeAll();
		SsibalMotherless.frame.add(out);
		SsibalMotherless.frame.repaint();
	}
	

}
