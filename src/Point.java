/*
 * Key points:
 * 1. A class is a customized type.
 * 2. A class contains several properties which determine the state/status of the object.
 * 3. A class can have multiple constructors with different parameters which are to initialize the properties.
 * 4. A class contains several methods which determine the behaviors of the class.
 * 5. Override toString() method to get the string representation of an object.
 * 6. Override equals() method to customize the equal-compare behavior.
 */
public class Point implements Comparable<Point> {
	private double x, y;
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	

	public double getX() {
		return x;
	}



	public void setX(double x) {
		this.x = x;
	}



	public double getY() {
		return y;
	}



	public void setY(double y) {
		this.y = y;
	}



	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}



	public double distance(Point p) {
		// TODO Auto-generated method stub
		double deltaX = this.x - p.x;
		double deltaY = this.y - p.y;
		return Math.sqrt(deltaX*deltaX + deltaY*deltaY);
	}

	public static double distance(Point p1, Point p2) {
		return p1.distance(p2);
	}

	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		return true;
	}



	@Override
	public int compareTo(Point o) {
		// TODO Auto-generated method stub
		if (this.x<o.x) {
			return -1;
		} 
		if (this.x > o.x) {
			return 1;
		}
		if (this.y < o.y) {
			return -1;
		} 
		if (this.y > o.y) {
			return 1;
		}
		
		return 0;
	}



	
	
	
}
