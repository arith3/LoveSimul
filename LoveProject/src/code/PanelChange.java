package namori.love.code;

import javax.swing.JPanel;

public class PanelChange {

	private static JPanel temp;
	
	protected static void convert(JPanel panel)
	{
        //LoveFrame.getFrame().getContentPane().removeAll();
		temp = (JPanel) LoveFrame.getFrame().getContentPane();
        LoveFrame.getFrame().setContentPane(panel);
        LoveFrame.getFrame().getContentPane().revalidate();
        LoveFrame.getFrame().getContentPane().repaint();
	}
	
	protected static void back()
	{
		LoveFrame.getFrame().setContentPane(temp);
        LoveFrame.getFrame().getContentPane().revalidate();
        LoveFrame.getFrame().getContentPane().repaint();
	}
}

/*
 * This class is change contentpane.
 * To convert panels from classes.
 * Coded by namori.
 */
