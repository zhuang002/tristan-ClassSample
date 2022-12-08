
public class LineSeg extends AbstractLine implements Line, Comparable<LineSeg> {
	private Point x;
	private Point y;
	
	/* for example:
	 * If we make lineSeg l1 = new LineSeg(new Point(1,2), new Point(4, 5))
	 * l2 = new LineSeg(new Point(4,5), new Point(1,2))
	 */
	
	public LineSeg(Point x, Point y) { 
		if (x.compareTo(y) <= 0) {
			this.x = x;
			this.y = y;
		} else {
			this.x = y;
			this.y = x;
		}
	}
	
	public LineSeg(int x1, int y1, int x2,int y2) {
		Point a = new Point(x1,y1);
		Point b = new Point(x2,y1);
		if (a.compareTo(b)<=0) {
			this.x = a;
			this.y = b;
		} else {
			this.x=b;
			this.y=a;
		}
	}

	public Point getX() {
		return x;
	}

	public void setX(Point x) {
		this.x = x;
	}

	public Point getY() {
		return y;
	}

	public void setY(Point y) {
		this.y = y;
	}
	
	public boolean containsPoint(Point p) {
		return false;
	}
	
	
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((x == null) ? 0 : x.hashCode());
		result = prime * result + ((y == null) ? 0 : y.hashCode());
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
		LineSeg other = (LineSeg) obj;
		if (x == null) {
			if (other.x != null)
				return false;
		} else if (!x.equals(other.x))
			return false;
		if (y == null) {
			if (other.y != null)
				return false;
		} else if (!y.equals(other.y))
			return false;
		return true;
	}

	@Override
	public int compareTo(LineSeg o) {
		// TODO Auto-generated method stub
		if (this.length() > o.length())
			return 1;
		if (this.length() < o.length())
			return -1;
		return 0;
	}

	private double length() {
		// TODO Auto-generated method stub
		return x.distance(y);
	}

	@Override
	public Point getIntersect(Line l) {
		// TODO Auto-generated method stub
		LineFormal line = getLineFormal();
		Point p = line.getIntersect(l);
		if (this.containsPoint(p))
			return p;
		return null;
	}


	@Override
	public LineFormal getLineFormal() {
		// TODO Auto-generated method stub
		if (this.isVertical()) {
			return new LineFormal(this.x.getX());
		}
		
		try {
			LineFormal line = new LineFormal(this.x,this.y);
			return line;
		} catch (InvalidParameterException e) {
			return null;
		}
	} 
	
	@Override
	public boolean isVertical() {
		// TODO Auto-generated method stub
		return Math.abs(this.x.getX()-this.y.getX())
				< AbstractLine.epsilon ;
	}
	
	
	
}
