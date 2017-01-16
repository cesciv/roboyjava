public class Dot {
	//instance variables
	private Color color;
	private int x;
	private int y;
	
	//method declarations
	public Dot(Color c, int x, int y) {
		this.color = c;
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return color + " , " + x + " , " + y;
	}
	
	public static void main(String [] args) {
		Dot test = new Dot(Color.RED, 5, 5);
		System.out.println(test);
	}
		
}