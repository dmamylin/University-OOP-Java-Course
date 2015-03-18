package lesson3_test;

import lesson3.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class Segment_test {
    @Test
    public void test_constructor_1() {
        Vector2d start = new Vector2d(0.0, 0.0);
        Vector2d end = new Vector2d(1.0, 0.0);
        Vector3d end_ = new Vector3d(1.0, 0.0, 0.0);
        
        Segment<Vector2d> segment = new Segment<>(start, end); // Можно
        //Segment<Vector2d> segment = new Segment<Vector2d>(start, end_); // Нельзя!
    }
    
    @Test
    public void test_constructor_2() {
        Vector2d start = new Vector2d(0.0, 0.0);
        Vector2d end = new Vector2d(0.000001, 0.0);
        
        Segment<Vector2d> segment = new Segment<>(start, end);
    }
    
    @Test
    public void test_distanceTo_1() {
        Vector2d start = new Vector2d(0.0, 0.0);
        Vector2d end = new Vector2d(1.0, 0.0);
        Segment<Vector2d> segment = new Segment<>(start, end);
        
        Vector2d testPoint = new Vector2d(0.5, 10.0);
        
        final double distance = segment.distanceTo(testPoint);
        final double resultDistance = 10.0;
        
        assertTrue(VectorCompare.compare(distance, resultDistance));
    }
}
