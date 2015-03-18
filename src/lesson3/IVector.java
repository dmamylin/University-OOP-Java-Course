package lesson3;

public interface IVector {
    public int dimension();
    public double getComponent(int i);
    public double length();
    public double dotProduct(IVector other);
    public IVector add(IVector other);
    public IVector sub(IVector other);
    public IVector mul(double scalar);
    public IVector negate();
    public IVector normalize();
    public boolean isEqual(IVector other);
    public double projectionTo(IVector other);
    @Override public String toString();
}
