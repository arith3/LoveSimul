package code;

public abstract class Person {//�߻�޼ҵ� ����
	
	private String name;
	private static String fileName;
	
	public abstract void talking();
	public abstract String Dialogue();
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		Person.fileName = fileName;
	}

}
