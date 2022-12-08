
public class LineRay extends AbstractLine implements Line {
	private Point start;
	private double angle; // 0<=angle<2pi
	
	public LineRay(Point p, double angle) {
		this.start = p;
		this.angle = angle;
	}
	
	public LineRay(Point start, Point direction) throws InvalidParameterException {
		if (start.equals(direction)) {
			throw new InvalidParameterException();
		}
		this.start = start;
		if (direction.getX() == start.getX()) {
			if (direction.getY() > start.getY()) {
				angle = Math.PI/2;
			} else {
				angle = 3*Math.PI/2;
			}
			return;
		}
		double slope = (direction.getY()-start.getY())/(direction.getX()-start.getX());
		angle = Math.atan(slope);
		if (direction.getX() > start.getX()) {
			if (slope < 0) { // in the 4th quadrant.
				angle += Math.PI;
			}
		} else if (direction.getX() < start.getX()) {
			if (slope > 0) { // in the 3rd quadrant
				angle += Math.PI;
			}
		}
		
	}

	public Point getStart() {
		return start;
	}

	public void setStart(Point start) {
		this.start = start;
	}

	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(angle);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((start == null) ? 0 : start.hashCode());
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
		LineRay other = (LineRay) obj;
		if (Double.doubleToLongBits(angle) != Double.doubleToLongBits(other.angle))
			return false;
		if (start == null) {
			if (other.start != null)
				return false;
		} else if (!start.equals(other.start))
			return false;
		return true;
	}

	@Override
	public boolean containsPoint(Point p) {
		// TODO Auto-generated method stub
		if (p.equals(start)) return true;
		
		if (this.start.equals(p)) {
			return true;
		}
		try {
			LineRay ray = new LineRay(this.start, p);
			if (Math.abs(angle - ray.getAngle())< AbstractLine.epsilon) {
				return true;
			}
			return false;
		} catch (InvalidParameterException e) {
			return false;
		}
	}


	@Override
	public Point getIntersect(Line l) {
		// TODO Auto-generated method stub
		LineFormal line = this.getLineFormal();
		
		Point p = line.getIntersect(l);
		if (this.containsPoint(p)) {
			return p;
		}
		return null;
		
	}

	

	@Override
	public LineFormal getLineFormal() {
		// TODO Auto-generated method stub
		if (this.isVertical()) {
			return new LineFormal(this.start.getX());
		}
		double k = Math.tan(angle);
		double m = start.getY() - k* start.getX();
		return new LineFormal(k, m);
	}
	
	@Override
	public boolean isVertical() {
		// TODO Auto-generated method stub
		return Math.abs(this.angle-Math.PI/2) < AbstractLine.epsilon 
				|| Math.abs(this.angle-3*Math.PI/2) < AbstractLine.epsilon;
	}

	
	
	
}
