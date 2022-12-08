
public class LineFormal extends AbstractLine implements Line {
	private double k;
	private double m;
	private boolean isVertical=false;
	
	public LineFormal(double k, double m) { // construct a non-vertical line.
		this.k = k;
		this.m = m;
		this.isVertical = false;
	}
	
	public LineFormal(double m) { // construct a vertical line.
		this.k = Double.MAX_VALUE;
		this.m = m;
		this.isVertical = true;
	}
	
	public LineFormal(Point p1, Point p2) throws InvalidParameterException {
		if (p1.equals(p2)) {
			throw new InvalidParameterException();
		}
		if (p1.getX() == p2.getX()) {// it is a vertical line.
			this.k = Double.MAX_VALUE;
			this.m = p1.getX();
			this.isVertical = true;
		} else {
			this.k = (p1.getY()-p2.getY()) / (p1.getX()-p2.getX());
			// y = k*x +m, m=y-k*x;
			this.m = p1.getY()-this.k*p1.getX();
			this.isVertical = false;
		}
	}
	
	public double getM() {
		return this.m;
	}

	@Override
	public boolean containsPoint(Point p) {
		// TODO Auto-generated method stub
		if (this.isVertical) {
			return Math.abs(p.getX() - this.m) < AbstractLine.epsilon;
		}
		return Math.abs(p.getY() - this.k*p.getX() + this.m) < AbstractLine.epsilon;
	}

	@Override
	public double distance(Point p) {
		// TODO Auto-generated method stub
		Point foot = getPerpFoot(p);
		return p.distance(foot);
	}

	@Override
	public Point getPerpFoot(Point p) {
		// TODO Auto-generated method stub
		Line l = getPerpLine(p);
		return getIntersect(l);
	}

	@Override
	public Line getPerpLine(Point p) {
		// TODO Auto-generated method stub
		if (this.isVertical) {// return a horizontal line.
			return new LineFormal(0, p.getY());
		}
		if (this.k==0) { // return a vertical line
			return new LineFormal(p.getX());
		}
		double newK = -1 / this.k;
		double newM = p.getY()-newK*p.getX();
		return new LineFormal(newK, newM);
		
	}

	@Override
	public Line getPrallelLine(Point p) {
		// TODO Auto-generated method stub
		if (this.containsPoint(p))
			return null;
		if (this.isVertical) {
			return new LineFormal(p.getX());
		}
		double newM = p.getY()-this.k*p.getX();
		return new LineFormal(this.k, newM);
	}

	@Override
	public boolean isParallel(Line l) {
		// TODO Auto-generated method stub
		if (this.isVertical) {
			return l.isVertical();
		}
		
		return Math.abs(this.k-l.getSlope()) < AbstractLine.epsilon;
	}


	@Override
	public boolean isPerpendicular(Line l) {
		// TODO Auto-generated method stub
		if (this.isVertical()) {
			if (l.isVertical()) {
				return false;
			} else {
				return Math.abs(l.getSlope()) < AbstractLine.epsilon;
			}
		} else {
			if (l.isVertical()) {
				return Math.abs(k) < AbstractLine.epsilon; 
			} else {
				return Math.abs(k*l.getSlope() + 1) < AbstractLine.epsilon;
			}
		}
	}

	@Override
	public Point getIntersect(Line l) {
		// TODO Auto-generated method stub
		LineFormal line = l.getLineFormal();
		if (this.isVertical()) {
			double y = line.getSlope() * this.m + line.getM();
			return new Point(this.m, y);
		} 
		if (line.isParallel(this)) {
			return null;
		}
		// solve the equation. y=k1*x+m1, y=k2*x+m2; x = -(m1-m2)/(k1-k2);
		double x = -(line.getM()-this.m)/(line.getSlope()-this.k);
		double y = this.k*x + this.m;
		
		return new Point(x,y);
	}

	@Override
	public double distance(Line l) {
		// TODO Auto-generated method stub
		if (!l.isParallel(this)) {
			return -1;
		}
		if (this.isVertical) {
			LineFormal line = l.getLineFormal();
			return Math.abs(this.m-line.getM());
		}
		
		double x = 0;
		double y = this.m;
		Point p = new Point(x,y);
		return l.distance(p);
	}

	@Override
	public boolean isVertical() {
		// TODO Auto-generated method stub
		return this.isVertical;
	}

	@Override
	public double getSlope() {
		// TODO Auto-generated method stub
		return this.k;
	}

	@Override
	public LineFormal getLineFormal() {
		// TODO Auto-generated method stub
		return this;
	}
	
	
}
