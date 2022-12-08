
public class MyTest {
	public void test() {
		LineSeg lseg = new LineSeg(new Point(0,0), new Point(2,3));
		Line l = lseg;
		l.isVertical();
		AbstractLine al=lseg;
		al.getSlope();
		Comparable<LineSeg> comp = lseg;
		comp.compareTo(lseg);
		
		/*
		 * 1. A class can implement multiple interfaces.
		 * 2. A class can have only one super class.
		 * 3. A class can use all the methods implemented in the super class. but a super class can only call the methods it implemented or its super class implemented.
		 * 4. An abstract class does not have to implement all the methods from a interface.
		 * 5. A non-abstract class has to implement all the methods in a interface to supports.
		 * 6. an interface casted from a class can call all the methods it defined, but it cannot call all the methods implemented by the class.
		 * 
		 */
		
	}
}
