package lesson2;

public class SquareValidator {
    private Vector3d fourthPoint;
    private boolean  pointsAreValid;
    private final double epsilon = 0.00001;
    
    SquareValidator() {
        fourthPoint = new Vector3d(0.0, 0.0, 0.0);
        pointsAreValid = false;
    }

    private boolean testPoints(Vector3d p1, Vector3d p2, Vector3d p3) {
        Vector3d v1 = p1.sub(p2); // Находим направляющие векторы сторон
        Vector3d v2 = p3.sub(p2); // Считая, что p2 - вершина
        
        // Если стороны ортогональны и их длины равны, то точки на квадрате        
        pointsAreValid = Math.abs(v1.dotProduct(v2)) <= epsilon &&
                         Math.abs(v1.length() - v2.length()) <= epsilon;
        
        // Если это так, находим 4ую точку
        if (pointsAreValid) {
            fourthPoint = p2.add(v1.add(v2));
        }
        
        return pointsAreValid;
    }
    
    public boolean pointsOnSquare(Vector3d p1, Vector3d p2, Vector3d p3) {
        return testPoints(p1, p2, p3) ||
               testPoints(p1, p3, p2) ||
               testPoints(p2, p1, p3);
    }
    
    public boolean isValid() {
        return pointsAreValid;
    }
    
    public Vector3d getFourthPoint() {
        return fourthPoint;
    }
}
