package lesson3;

final public class LineSegment {
    private final IVector startPoint;
    private final IVector endPoint;
    
    public LineSegment(IVector startPoint, IVector endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }
    
    public IVector getStartPoint() {
        return startPoint;
    }
    
    public IVector getEndPoint() {
        return endPoint;
    }
    
    public IVector getDirectionVector() {
        return endPoint.sub(endPoint);
    }
    
    public double length() {
        return endPoint.sub(startPoint).length();
    }
    
    public IVector linearInterpolation(double alpha) {
        return startPoint.add(endPoint.sub(startPoint).mul(alpha));
    }
    
    public double distanceTo(IVector point) {
        IVector triangleSide1 = point.sub(startPoint).normalize();
        IVector triangleSide2 = getDirectionVector().normalize();
        double cosBetween = triangleSide1.dotProduct(triangleSide2);
        double projLength = cosBetween * triangleSide1.length();
        
        return triangleSide2.mul(projLength).sub(point).length();
    }
}
