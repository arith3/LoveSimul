package code;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class heroine extends Person{//inheritance ����

	private String fileName;
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	static String talk[]=new String[100];
	int heroinecount=0;
	int count;
	
	@Override
	public void talking() {
		try {
			BufferedReader inputFile=new BufferedReader(new FileReader("./texts/heroine.txt"));
			String str=null;
			try {
				while((str=inputFile.readLine())!=null)
					talk[count++]=str;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public String Dialogue() {

		return talk[heroinecount++];
		//return �� �� heroinecount�� ���� �ϳ� �÷��ְ� ��縦 ������
	}
}
