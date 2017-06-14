package code;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import gui.Stat;
//자바 내에서 cmd창을 실행하게 하는 코드
public class CMDcompile {
	
	public void Play(String route, String fname)
	{
		try {
			Runtime rt = Runtime.getRuntime();
			System.out.println(route + fname);
			Process proc = rt.exec("javac -classpath . " + route + fname);
			/*----------------------------------------*/
			// This is core code!!
			InputStream stderr = proc.getErrorStream();
			InputStreamReader isr = new InputStreamReader(stderr);
			BufferedReader br = new BufferedReader(isr);
			String line = null;
			System.out.println("<ERROR>");
			while ((line = br.readLine()) != null) {
				System.out.println(line);
				Stat.getMSG().add(line);
			}
			System.out.println("</ERROR>");
			/*----------------------------------------*/
			int exitVal = proc.waitFor();
			System.out.println("Process exitValue: " + exitVal);
		} catch (Throwable t) {
			t.printStackTrace();
		}
		
//	
//		try {
//			//Scanner scan = new Scanner(System.in);
//			//System.out.print("INSERT DOS COMMAND :");
//			String command = "javac "+fname; //scan.next();
//			String command2 = "cd "+route;
//			String cmd[] = new String[4];
//			cmd[0] = "cmd.exe";
//			cmd[1] = "/C";
//			cmd[2] = "javac";
//			cmd[3] = "-version";
//			//System.out.println("This is "+cmd[0]+cmd[1]+cmd[2]+cmd[3]);
//
//			//Runtime runTime = Runtime.getRuntime();
//			Process process = new ProcessBuilder("cmd.exe dir").start(); //runTime.exec(cmd);
//			//process.waitFor();
////			InputStream is = process.getInputStream();
////			InputStreamReader isr = new InputStreamReader(is);
////			BufferedReader br = new BufferedReader(isr);
//			BufferedReader stdOut = new BufferedReader(new InputStreamReader(process.getInputStream()));
//
//
//			String line;
//
//			while ((line = stdOut.readLine()) != null) {
//				System.out.println(line);
//			}
////
//			int execTime = process.waitFor();
//			System.out.println("exectiog time: " + execTime);
//		} catch (Throwable t) {
//			t.printStackTrace();
//		}
	}
}
