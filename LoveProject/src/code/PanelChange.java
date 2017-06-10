package code;

import java.util.ArrayList;

import javax.swing.JPanel;

public class PanelChange {

	private static ArrayList<JPanel> array = new ArrayList<JPanel>();
	private static int cnt = 0;;
	
	protected static void convert(JPanel panel)
	{
		array.add(0, (JPanel) LoveFrame.getFrame().getContentPane());
		cnt++;
        LoveFrame.getFrame().setContentPane(panel);
        LoveFrame.getFrame().getContentPane().revalidate();
        LoveFrame.getFrame().getContentPane().repaint();
        System.out.println(array.size());
	}
	
	protected static void back()
	{
		LoveFrame.getFrame().setContentPane(array.get(cnt - 1));
        LoveFrame.getFrame().getContentPane().revalidate();
        LoveFrame.getFrame().getContentPane().repaint();
	}
	
	protected static void backback()
	{
		LoveFrame.getFrame().setContentPane(array.get(cnt - 2));
        LoveFrame.getFrame().getContentPane().revalidate();
        LoveFrame.getFrame().getContentPane().repaint();
	}
}

/*
 * This class is change contentpane.
 * To convert panels from classes.
 * Coded by namori.
 */