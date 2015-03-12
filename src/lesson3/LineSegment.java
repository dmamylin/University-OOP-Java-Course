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
        return endPoint.sub(startPoint).normalize();
    }
    
    public double length() {
        return endPoint.sub(startPoint).length();
    }
    
    public IVector linearInterpolation(double alpha) {
        return startPoint.add(endPoint.sub(startPoint).mul(alpha));
    }
    
    public double distanceTo(IVector point) {
        IVector triangleSide1 = point.sub(startPoint);
        IVector triangleSide2 = endPoint.sub(startPoint);
        double cosBetween = triangleSide1.dotProduct(triangleSide2);
        double projLength = cosBetween / triangleSide2.length();
        
        return triangleSide2.normalize().mul(projLength).add(startPoint).sub(point).length();
    }
}
