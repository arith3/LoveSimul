package namori.love.code;

public abstract class Person {//�߻�޼ҵ� ����
	
	private String name;
	
	public abstract void talking();
	public abstract String Dialogue();
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
