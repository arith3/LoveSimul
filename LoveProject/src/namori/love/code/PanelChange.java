package namori.love.code;

import javax.swing.JPanel;

public class PanelChange {

	protected static void convert(JPanel panel)
	{
        LoveFrame.getFrame().getContentPane().removeAll();
        LoveFrame.getFrame().setContentPane(panel);
        LoveFrame.getFrame().getContentPane().repaint();
	}
}

/*
 * This class is change contentpane.
 * To convert panels from classes.
 * Coded by namori.
 */
