package code;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class hero extends Person {// inheritance 만족

	private String fileName;
	static String talk[] = new String[100];
	private int herocount = 0;
	private int count = 0;
	private String who;
	

	public void loginsetting(String str)
	{
		who = str;
	}
	
	@Override
	public void talking() {
		try {
			BufferedReader inputFile = new BufferedReader(new FileReader("./texts/hero.txt"));
			String str = null;
			try {
				while ((str = inputFile.readLine()) != null)
					talk[count++] = str;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String Dialogue() {

		return talk[herocount++];
		// return 할 때 herocount의 수를 하나 늘려주고 대사를 리턴함
	}

}