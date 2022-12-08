
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Class sample");
		
		/*
		 * If we want to new an object with parameters, we need to write our constructors by ourself
		 */
		Point p1 = new Point(0, 1);
		Point p2 = new Point(100, 200);

		/*
		 * If we want to turn an object to string other than the default implementation of Object class,
		 * we need to override the toString() method.
		 */
		System.out.println(p1);
		System.out.println(p2);
		
		double distance = p1.distance(p2);
		System.out.println("The distance from p1 to p2 is "+distance);
		distance = p2.distance(p1);
		System.out.println("The distance from p2 to p1 is "+distance);
		
		distance = Point.distance(p1, p2);
		
		
		
		if (p1.equals(p2)) {
			System.out.println("p1 and p2 are equal.");
		} else {
			System.out.println("p1 and p2 are different");
		}
		
		
		/*
		 * If you want to customize your own equals() method, you need to override equals() method.
		 */
		Point p3 = new Point(100, 200);
		if (p2.equals(p3)) {
			System.out.println("p2 and p3 are equal.");
		} else {
			System.out.println("p2 and p3 are different");
		}
		
		/*
		 * Key points:
		 * 1. The assignment of object is actually assign the reference of the object.
		 * 2. When you compare 2 objects and their class has not implment the equals() method,
		 * the equals() method of their super class will be used, be default it is Object.equals() method,
		 * which is to compare their references. 
		 * 
		 */
		Point p4 = p1;
		if (p1.equals(p4)) {
			System.out.println("p1 and p4 are equal.");
		} else {
			System.out.println("p1 and p4 are different");
		}
		
	}
	

}
