package lesson3;

public class Vector3d implements IVector {
    public final double x, y, z;
    
    @Override
    public int dimension() {
        return 3;
    }
    
    @Override
    public double getComponent(int i) {
        switch(i) {
            case 0:
                return x;
            case 1:
                return y;
            case 2:
                return z;
            default:
                System.out.println("Wrong vector component number: " + i);
                return Double.NaN;
        }
    }
    
    public Vector3d(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    @Override
    public double length() {
        return Math.sqrt(dotProduct(this));
    }
    
    @Override
    public double dotProduct(IVector other) {
        Vector3d v = (Vector3d)other;
        return x*v.x + y*v.y + z*v.z;
    }
    
    @Override
    public IVector add(IVector other) {
        Vector3d v = (Vector3d)other;
        return new Vector3d(x + v.x, y + v.y, z + v.z);
    }
    
    @Override
    public IVector sub(IVector other) {
        Vector3d v = (Vector3d)other;
        return new Vector3d(x - v.x, y - v.y, z - v.z);
    }
    
    @Override
    public IVector mul(double scalar) {
        return new Vector3d(scalar * x, scalar * y, scalar * z);
    }
    
    @Override
    public IVector negate() {
        return new Vector3d(-x, -y, -z);
    }
    
    @Override
    public IVector normalize() {
        double len = this.length();
        return new Vector3d(x / len, y / len, z / len);
    }
    
    @Override
    public boolean isEqual(IVector other) {
        Vector3d v = (Vector3d)other;
        return Double.compare(x, v.x) == 0 &&
               Double.compare(y, v.y) == 0 &&
               Double.compare(z, v.z) == 0;
    }
    
    @Override
    public double projectionTo(IVector other) {
        return dotProduct(other) / other.length();
    }
    
    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
    
    public Vector3d crossProduct(Vector3d other) {
        return new Vector3d(y * other.z - z * other.y,
                            z * other.x - x * other.z,
                            x * other.y - y * other.x);
    }
}
