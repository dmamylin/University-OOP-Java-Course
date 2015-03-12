package lesson3;

public class Vector2d implements IVector {
    public final double x, y;
    
    public Vector2d(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public double length() {
        return Math.sqrt(dotProduct(this));
    }
    
    @Override
    public double dotProduct(IVector other) {
        Vector2d v = (Vector2d)other;
        return x*v.x + y*v.y;
    }
    
    @Override
    public IVector add(IVector other) {
        Vector2d v = (Vector2d)other;
        return new Vector2d(x + v.x, y + v.y);
    }
    
    @Override
    public IVector sub(IVector other) {
        Vector2d v = (Vector2d)other;
        return new Vector2d(x - v.x, y - v.y);
    }
    
    @Override
    public IVector mul(double scalar) {
        return new Vector2d(scalar * x, scalar * y);
    }
    
    @Override
    public IVector negate() {
        return new Vector2d(-x, -y);
    }
    
    @Override
    public IVector normalize() {
        double len = this.length();
        return new Vector2d(x / len, y / len);
    }
    
    @Override
    public boolean isEqual(IVector other) {
        Vector2d v = (Vector2d)other;
        return Double.compare(x, v.x) == 0 &&
               Double.compare(y, v.y) == 0;
    }
    
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
