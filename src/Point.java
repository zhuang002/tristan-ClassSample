/*
 * Key points:
 * 1. A class is a customized type.
 * 2. A class contains several properties which determine the state/status of the object.
 * 3. A class can have multiple constructors with different parameters which are to initialize the properties.
 * 4. A class contains several methods which determine the behaviors of the class.
 * 5. Override toString() method to get the string representation of an object.
 * 6. Override equals() method to customize the equal-compare behavior.
 */
public class Point {
	private int x, y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	
	
	



	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}







	public double distance(Point p) {
		// TODO Auto-generated method stub
		int deltaX = this.x - p.x;
		int deltaY = this.y - p.y;
		return Math.sqrt(deltaX*deltaX + deltaY*deltaY);
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
	
}
