
public interface Line {
	boolean containsPoint(Point p);
	double distance(Point p);
	Point getPerpFoot(Point p);
	Line getPerpLine(Point p);
	Line getPrallelLine(Point p);
	boolean isParallel(Line l);
	boolean isPerpendicular(Line l);
	Point getIntersect(Line l);
	double distance(Line l);
	boolean isVertical();
	double getSlope();
	LineFormal getLineFormal();
}
