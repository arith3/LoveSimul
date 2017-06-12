package unit_test;

import javax.swing.JPanel;

public class ChangeUnitTest {
	
	protected static void change(JPanel out)
	{
//		SsibalMotherless.frame.remove(mainPane);
//		SsibalExam ex = new SsibalExam(1);
//		SsibalMotherless.frame.add(ex.getMain());
//		SsibalMotherless.frame.repaint();

		MainUnitTest.getFrame().removeAll();
		MainUnitTest.getFrame().add(out);
		MainUnitTest.getFrame().repaint();
	}
	

}
