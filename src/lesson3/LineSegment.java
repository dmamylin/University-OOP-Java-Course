package lesson3;

final public class LineSegment implements IPrecision {
    private final IVector startPoint;
    private final IVector endPoint;
    private final IVector dirVector; // Направляющий вектор
    
    public LineSegment(IVector startPoint, IVector endPoint) {
        this.startPoint = startPoint; //TODO: исключение для совпадающих точек
        this.endPoint = endPoint;
        dirVector = endPoint.sub(startPoint).normalize(); // Вычисляем направляющий вектор
    }
    
    public IVector getStartPoint() {
        return startPoint;
    }
    
    public IVector getEndPoint() {
        return endPoint;
    }
    
    public double length() {
        return endPoint.sub(startPoint).length();
    }
}
