package lesson3;

final public class LineSegment {
    private final IVector startPoint;
    private final IVector endPoint;
    
    // Точки должны находиться в пространстве одной размерности и не совпадать
    // Иначе будет выброшено исключение IllegalArgumentException
    public LineSegment(IVector startPoint, IVector endPoint) {
        if (startPoint.dimension() != endPoint.dimension()) {
            throw new IllegalArgumentException(
                    "Points must be in a same linear space. Dimension mismatch!");
        }
        
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
        // Сначала находим проекцию точки point на прямуювдоль ее нормали,
        // содержащую данный отрезок
        IVector triangleSide1 = point.sub(startPoint);
        IVector triangleSide2 = endPoint.sub(startPoint);
        double cosBetween = triangleSide1.dotProduct(triangleSide2);
        double projLength = cosBetween / triangleSide2.length();
        
        // Нашли
        IVector projection = triangleSide2.normalize().mul(projLength).add(startPoint);
        
        // Проверяем, содержит ли отрезок найденную точку
        double coeff = point.sub(startPoint).length() / startPoint.sub(endPoint).length();
        if (coeff <= 1.0 && endPoint.sub(startPoint).dotProduct(point.sub(startPoint)) >= 0.0) { // Содержит
            return projection.sub(point).length();
        } else {
            return Math.min(point.sub(startPoint).length(), point.sub(endPoint).length());
        }
    }
}
