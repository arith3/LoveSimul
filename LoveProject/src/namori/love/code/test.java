package namori.love.code;

public class test {

	public static void main(String[] args) {
		Person h=new hero();//polymorphism ¸¸Á·
		Person he=new heroine();
		
		h.setName("Bokyems");
		he.setName("sopung");
		
		h.talking();
		he.talking();
		
		System.out.println(h.getName());
		System.out.println(h.Dialogue());
		System.out.println(h.Dialogue());
		System.out.println(he.Dialogue());
	}
}