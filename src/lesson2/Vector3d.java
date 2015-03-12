package lesson2;

public class Vector3d {
    public double x, y, z;
    
    public Vector3d(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public Vector3d add(Vector3d other) {
        return new Vector3d(x + other.x, y + other.y, z + other.z);
    }
    
    public Vector3d sub(Vector3d other) {
        return new Vector3d(x - other.x, y - other.y, z - other.z);
    }
    
    public Vector3d mul(double scalar) {
        return new Vector3d(scalar * x, scalar * y, scalar * z);
    }
    
    public double dotProduct(Vector3d other) {
        return x * other.x + y * other.y + z * other.z;
    }
    
    public double length() {
        return Math.sqrt(dotProduct(this));
    }
    
    public Vector3d crossProduct(Vector3d other) {
        return new Vector3d(y * other.z - z * other.y,
                            z * other.x - x * other.z,
                            x * other.y - y * other.x);
    }
    
    public String toString() {
        return new String("(" + x + ", " + y + ", " + z + ")");
    }
}
