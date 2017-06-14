package code;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
//자바 내에서 cmd창을 실행하게 하는 코드
public class CMDcompile {

	private String rout2e;
	private String fnam2e;
	
	
	public void Play(String route, String fname)
	{
		try {
			//Scanner scan = new Scanner(System.in);
			//System.out.print("INSERT DOS COMMAND :");
			String command = "javac "+fname; //scan.next();
			String command2 = "cd "+route;
			String cmd[] = new String[4];
			cmd[0] = "cmd.exe";
			cmd[1] = "/C";
			cmd[2] = "javac";
			cmd[3] = "-version";
			System.out.println("This is "+cmd[0]+cmd[1]+cmd[2]+cmd[3]);

			Runtime runTime = Runtime.getRuntime();
			Process process = runTime.exec(cmd);

			InputStream is = process.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);

			String line;

			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}

			int execTime = process.waitFor();
			System.out.println("exectiog time: " + execTime);
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}
}
