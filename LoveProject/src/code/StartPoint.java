package code;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class StartPoint {

	//자바 내에서 cmd창을 실행하게 하는 코드
	public static void main(String[] args) {
		try {
			Scanner scan = new Scanner(System.in);
			System.out.print("INSERT DOS COMMAND :");
			String command = scan.next();

			String cmd[] = new String[3];
			cmd[0] = "cmd.exe";
			cmd[1] = "/C";
			cmd[2] = command;

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

	// try {
	// String source = "package test; public class Test { static {
	// System.out.println(\"hello\"); } public Test() {
	// System.out.println(\"world\"); } }";
	//
	// // Save source in .java file.
	// File root = new File("C:\\Users\\Arith\\Documents\\aaa"); // On Windows
	// running on C:\, this is
	// // C:\java.
	// File sourceFile = new File(root, "\\test\\Test.java");
	// sourceFile.getParentFile().mkdirs();
	// FileWriter test_writer = new FileWriter(sourceFile);
	// test_writer.append(source);
	// test_writer.close();
	//
	// // Compile source file.
	// JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
	// compiler.run(System.in, System.out, System.err, sourceFile.getPath());
	//
	// // Load and instantiate compiled class.
	// URLClassLoader classLoader = URLClassLoader.newInstance(new URL[] {
	// root.toURI().toURL() });
	// Class<?> cls = Class.forName("test.Test", true, classLoader); // Should
	// // print
	// // "hello".
	// Object instance = cls.newInstance(); // Should print "world".
	// System.out.println(instance); // Should print "test.Test@hashcode".
	// } catch (Exception ex) {
	// System.out.println(ex.getMessage());
	// }
}
