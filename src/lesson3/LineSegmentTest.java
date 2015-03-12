package lesson3;

import org.junit.* ;
import static org.junit.Assert.* ;

public class LineSegmentTest {
    private final Vector2d p1_2d = new Vector2d(1.0, 0.0);
    private final Vector2d p2_2d = new Vector2d(0.0, 0.0);
    private final Vector3d p3_3d = new Vector3d(1.0, 1.0, 0.0);
    private final Vector3d p4_3d = new Vector3d(1.0, 1.0, 1.0);
        
    private final LineSegment lineSegment1_2d = new LineSegment(p1_2d, p2_2d);
    private final LineSegment lineSegment2_3d = new LineSegment(p3_3d, p4_3d);
    
    private final Vector2d testPoint1_2d = new Vector2d(0.0, 2.0);
    private final Vector3d testPoint2_3d = new Vector3d(0.0, 0.0, 0.0);
    
    @Test
    public void test_DirVector1() {
        Vector2d dirVector = (Vector2d)lineSegment1_2d.getDirectionVector();
        assertTrue(Double.compare(dirVector.x, -1.0) == 0 &&
                Double.compare(dirVector.y, 1.0) == 0);
    }
    
    @Test
    public void test_DirVector2() {
        Vector3d dirVector = (Vector3d)lineSegment2_3d.getDirectionVector();
        assertTrue(Double.compare(dirVector.x, 0.0) == 0 &&
                Double.compare(dirVector.y, 0.0) == 0 &&
                Double.compare(dirVector.z, 1.0) == 0);
    }
    
    @Test
    public void test_DistanceTo1() {
        assertTrue(Double.compare(
                lineSegment1_2d.distanceTo(testPoint1_2d), 2.0) == 0);
    }
    
    @Test
    public void test_DistanceTo2() {
        assertTrue(Double.compare(
                lineSegment2_3d.distanceTo(testPoint2_3d), 1.0) == 0);
    }
}
