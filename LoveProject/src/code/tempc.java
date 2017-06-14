package code;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class tempc {
	public static void main(String[] args) {
		try {
			Scanner scan = new Scanner(System.in);
			System.out.print("INSERT DOS COMMAND :");
			String command = scan.next();

			String cmd[] = new String[3];
			cmd[0] = "cmd.exe";
			cmd[1] = "/C";
			cmd[2] = command;
			//cmd[3] = "C:\\";

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
