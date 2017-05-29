package namori.love.code;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class LoveExam extends JPanel {

	private static final long serialVersionUID = 1L;

	private int ExamNum;
	private int G_status;
	/**
	 * Create the panel.
	 */
	public LoveExam(int num)
	{
		setExamNum(num);
		//G_status = Girl.status;
		Testing();
	}
	
	private boolean Testing()
	{
		
		
		return false;	
	}
	
	private JPanel ShowTest()
	{
		JPanel pan = new JPanel();
		
		pan.setSize(1280, 720);
		
		TitledBorder name = new TitledBorder("Exam!");
		pan.setBorder(name);
		
		JButton no1 = new JButton("");
		JButton no2 = new JButton("");
		JButton no3 = new JButton("");
		
		pan.add(no1);
		pan.add(no2);
		pan.add(no3);
		
		
		
		
		
		
		return pan;
	}
	
	
	
	
	
	
	
	
	
	
	
	public int getExamNum() {
		return ExamNum;
	}
	public void setExamNum(int examNum) {
		ExamNum = examNum;
	}

	
	
	
	
	
	
}
