package lesson3;

//отрезок:
//length
//distance from point to...
//test all methods

//Создать vec2 и vec3 от IVector

public interface IVector {
    public double length();
    public double dotProduct(IVector other);
    public IVector add(IVector other);
    public IVector sub(IVector other);
    public IVector mul(double scalar);
    public IVector negate();
    public IVector normalize();
    public boolean isEqual(IVector other);
    @Override public String toString();
}
