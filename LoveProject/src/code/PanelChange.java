package code;

import javax.swing.JPanel;

public class PanelChange {

	private static JPanel temp;
	
	protected static void convert(JPanel panel)
	{
        //LoveFrame.getFrame().getContentPane().removeAll();
		temp = (JPanel) Main.getFrame().getContentPane();
        Main.getFrame().setContentPane(panel);
        Main.getFrame().getContentPane().revalidate();
        Main.getFrame().getContentPane().repaint();
	}
	
	protected static void back()
	{
		Main.getFrame().setContentPane(temp);
        Main.getFrame().getContentPane().revalidate();
        Main.getFrame().getContentPane().repaint();
	}
}

/*
 * This class is change contentpane.
 * To convert panels from classes.
 * Coded by namori.
 */
