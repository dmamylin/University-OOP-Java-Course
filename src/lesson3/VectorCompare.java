package lesson3;

public class VectorCompare {
    public static final double precision = 1e-9;
    
    public static boolean compare(double a, double b) {
        return Math.abs(a - b) < precision;
    }
    
    public static boolean compare(Vector2d v1, Vector2d v2) {
        int dimension = v1.dimension();
        for (int i = 0; i < dimension; i++) {
            if (!compare(v1.getComponent(i), v2.getComponent(i))) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean compare(Vector3d v1, Vector3d v2) {
        int dimension = v1.dimension();
        for (int i = 0; i < dimension; i++) {
            if (!compare(v1.getComponent(i), v2.getComponent(i))) {
                return false;
            }
        }
        return true;
    }
}
