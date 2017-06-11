package code;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Hint {
	public static ArrayList<String> hint = new ArrayList<String>();
	public static int hintcnt=0;
	public void getDialogue(){
		try {
			BufferedReader br = new BufferedReader(new FileReader("./texts/hint.txt"));

			// FileReader("Problem.txt"));
			while(true) {
				String line = br.readLine();
				if (line == null)
					break;
				hint.add(line);
				hintcnt++;
			}
			br.close();			
		} catch (IOException a) {
			System.out.println("Can't Read");
		}
	}
	public ArrayList<String> getHint() {
		return hint;
	}
	public void setHint(ArrayList<String> hint) {
		this.hint = hint;
	}
	
}
