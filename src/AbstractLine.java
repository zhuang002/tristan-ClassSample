
public abstract class AbstractLine implements Line {
	static final double epsilon = 0.00000001;
	
	@Override
	public Point getPerpFoot(Point p) {
		// TODO Auto-generated method stub
		Line line = getLineFormal();
		return line.getPerpFoot(p);

	}
	
	@Override
	public Line getPerpLine(Point p) {
		// TODO Auto-generated method stub
		Line line = getLineFormal();
		return line.getPerpLine(p);
	}
	
	@Override
	public Line getPrallelLine(Point p) {
		// TODO Auto-generated method stub
		Line line = getLineFormal();
		return line.getPerpLine(p);
	}
	
	@Override
	public boolean isParallel(Line l) {
		// TODO Auto-generated method stub
		Line line = getLineFormal();
		return line.isParallel(l);
	}
	
	@Override
	public boolean isPerpendicular(Line l) {
		// TODO Auto-generated method stub
		Line line = getLineFormal();
		return line.isPerpendicular(l);
	}
	
	@Override
	public double distance(Line l) {
		// TODO Auto-generated method stub
		Line line = getLineFormal();
		return line.distance(l);
	}
	
	
	@Override
	public double getSlope() {
		// TODO Auto-generated method stub
		Line line = getLineFormal();
		return line.getSlope();
	}

	@Override
	public double distance(Point p) {
		Point foot = this.getPerpFoot(p);
		return foot.distance(p);
	}
	
}
