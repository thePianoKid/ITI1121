import java.awt.*;

public class FirstProject {
	public static void main (String[] args) {
		Point p1 = new Point(1, 2);
		Point p2 = p1;	
		
		p1.x = 4;

		System.out.println(p2);
	}
}
