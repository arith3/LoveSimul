package namori.love.code;

import java.util.ArrayList;

public class Exams {

	private int ExamNum;
	private ArrayList<String> arr;
	
	protected String getProblem(int i)
	{
		
		return "";
	} //문제를 빼오는 기능
	
	protected String[] getChoice(int i)
	{
		
		return null;
	} //선택지만 빼오는 기능
	
	protected int getAnswer(int i)
	{
		int ans = 0;
		
		
		return 0;
	} //답 빼오는 기능
	
	protected void array()
	{
		arr = new ArrayList<String>();
		
		arr.add(null);
		//이런식으로 문제 때려박는거 맞냐??
		arr.add("Your name?");
		
		
	}
	
}
