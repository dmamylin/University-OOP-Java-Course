package lesson3;

public class Lesson3 {
    private static final Vector2d p1_2d = new Vector2d(1.0, 0.0);
    private static final Vector2d p2_2d = new Vector2d(0.0, 0.0);
    private static final Vector3d p3_3d = new Vector3d(1.0, 1.0, 0.0);
    private static final Vector3d p4_3d = new Vector3d(1.0, 1.0, 1.0);
    
    private static final LineSegment lineSegment1_2d = new LineSegment(p1_2d, p2_2d);
    private static final LineSegment lineSegment2_3d = new LineSegment(p3_3d, p4_3d);
    
    private static final Vector2d testPoint1_2d = new Vector2d(0.0, 2.0);
    private static final Vector3d testPoint2_3d = new Vector3d(0.0, 0.0, 0.0);
    
    public static void main(String args[]) {
        Vector2d dirVector1 = (Vector2d)lineSegment1_2d.getDirectionVector();
        System.out.println(dirVector1.toString());
        
        Vector3d dirVector2 = (Vector3d)lineSegment2_3d.getDirectionVector();
        System.out.println(dirVector2.toString());
        
        System.out.println(lineSegment1_2d.distanceTo(testPoint1_2d));
        
        System.out.println(lineSegment2_3d.distanceTo(testPoint2_3d));
    }
}
