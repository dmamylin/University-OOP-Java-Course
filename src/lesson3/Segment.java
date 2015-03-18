package lesson3;

public class Segment<TVector extends IVector> {
    TVector startPoint;
    TVector endPoint;
    
    // Точки не должны совпадать, иначе будет выброшено исключение
    public Segment(TVector startPoint, TVector endPoint) {
        int dimension = startPoint.dimension();
        boolean pointsAreEqual = true;
        
        for (int i = 0; i < dimension; i++) {
            if (Double.compare(startPoint.getComponent(i),
                    endPoint.getComponent(i)) != 0) {
                pointsAreEqual = false;
                break;
            }
        }
        
        if (pointsAreEqual) {
            throw new IllegalArgumentException(
                    "There is no unique line through an equal points!");
        }
        
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }
    
    public TVector getStartPoint() {
        return startPoint;
    }
    
    public TVector getEndPoint() {
        return endPoint;
    }
    
    public TVector getDirectionVector() {
        return (TVector)endPoint.sub(startPoint).normalize();
    }
    
    public double getLength() {
        return endPoint.sub(startPoint).length();
    }
    
    public TVector linearInterpolation(double alpha) {
        return (TVector)startPoint.add(endPoint.sub(startPoint).mul(alpha));
    }
    
    public double distanceTo(TVector point) {
        TVector triangleSide1 = (TVector)point.sub(startPoint);
        TVector triangleSide2 = (TVector)endPoint.sub(startPoint);
        double cosBetween = triangleSide1.dotProduct(triangleSide2);
        double projLength = cosBetween / triangleSide2.length();
        
        return triangleSide2.normalize().mul(projLength).add(startPoint).sub(point).length();
    }
}