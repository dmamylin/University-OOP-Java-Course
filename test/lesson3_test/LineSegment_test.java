package lesson3_test;

import lesson3.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class LineSegment_test {
    @Test
    public void test_distanceTo_1() {
        Vector2d start = new Vector2d(0.0, 0.0);
        Vector2d end = new Vector2d(0.0, 1.0);
        Vector2d testPoint = new Vector2d(1.0, 0.0);
        
        LineSegment line = new LineSegment(start, end);
        
        final double testResult = 1.0;
        double distance = line.distanceTo(testPoint);
        
        assertTrue(VectorCompare.compare(distance, testResult));
    }
    
    @Test
    public void test_distanceTo_2() {
        Vector2d start = new Vector2d(0.0, 0.0);
        Vector2d end = new Vector2d(0.0, 100.0);
        Vector2d testPoint = new Vector2d(1.0, 0.0);
        
        LineSegment line = new LineSegment(start, end);
        
        final double testResult = 1.0;
        double distance = line.distanceTo(testPoint);
        
        assertTrue(VectorCompare.compare(distance, testResult));
    }
    
    @Test
    public void test_distanceTo_3() {
        Vector2d start = new Vector2d(3.0, 0.0);
        Vector2d end = new Vector2d(0.0, 0.0);
        Vector2d testPoint = new Vector2d(1.0, 0.0);
        
        LineSegment line = new LineSegment(start, end);
        
        final double testResult = 0.0;
        double distance = line.distanceTo(testPoint);
        
        assertTrue(VectorCompare.compare(distance, testResult));
    }
    
    @Test
    public void test_distanceTo_4() {
        Vector2d start = new Vector2d(3.0, 0.0);
        Vector2d end = new Vector2d(0.0, 0.0);
        Vector2d testPoint = new Vector2d(2000.0, 0.0);
        
        LineSegment line = new LineSegment(start, end);
        
        final double testResult = Math.min(start.sub(testPoint).length(),
                end.sub(testPoint).length());
        double distance = line.distanceTo(testPoint);
        
        assertTrue(VectorCompare.compare(distance, testResult));
    }
    
    @Test
    public void test_distanceTo_5() {
        Vector2d start = new Vector2d(3.0, 0.0);
        Vector2d end = new Vector2d(0.0, 0.0);
        Vector2d testPoint = new Vector2d(0.0, 50.0);
        
        LineSegment line = new LineSegment(start, end);
        
        final double testResult = 50.0;
        double distance = line.distanceTo(testPoint);
        
        assertTrue(VectorCompare.compare(distance, testResult));
    }
    
    @Test
    public void test_distanceTo_6() {
        Vector2d start = new Vector2d(3.0, 2.0);
        Vector2d end = new Vector2d(0.0, 2.0);
        Vector2d testPoint = new Vector2d(0.0, 50.0);
        
        LineSegment line = new LineSegment(start, end);
        
        final double testResult = 48.0;
        double distance = line.distanceTo(testPoint);
        
        assertTrue(VectorCompare.compare(distance, testResult));
    }
    
    @Test
    public void test_distanceTo_7() {
        Vector2d start = new Vector2d(3.0, -2.0);
        Vector2d end = new Vector2d(0.0, -2.0);
        Vector2d testPoint = new Vector2d(0.0, 52.0);
        
        LineSegment line = new LineSegment(start, end);
        
        final double testResult = 54.0;
        double distance = line.distanceTo(testPoint);
        
        assertTrue(VectorCompare.compare(distance, testResult));
    }
    
    @Test
    public void test_distanceTo_8() {
        Vector2d start = new Vector2d(30.0, -2.0);
        Vector2d end = new Vector2d(27.0, -2.0);
        Vector2d testPoint = new Vector2d(0.0, 52.0);
        
        LineSegment line = new LineSegment(start, end);
        
        final double testResult = Math.min(start.sub(testPoint).length(),
                end.sub(testPoint).length());
        double distance = line.distanceTo(testPoint);
        
        assertTrue(VectorCompare.compare(distance, testResult));
    }
    
    @Test
    public void test_distanceTo_9() {
        Vector2d start = new Vector2d(30.0, -2.0);
        Vector2d end = new Vector2d(0.0, -2.0);
        Vector2d testPoint = new Vector2d(0.0, 52.0);
        
        LineSegment line = new LineSegment(start, end);
        
        final double testResult = Math.min(start.sub(testPoint).length(),
                end.sub(testPoint).length());
        double distance = line.distanceTo(testPoint);
        
        assertTrue(VectorCompare.compare(distance, testResult));
    }
    
    @Test
    public void test_distanceTo_10() {
        Vector2d start = new Vector2d(30.0, -2.0);
        Vector2d end = new Vector2d(-30.0, -2.0);
        Vector2d testPoint = new Vector2d(0.0, 52.0);
        
        LineSegment line = new LineSegment(start, end);
        
        final double testResult = Math.min(start.sub(testPoint).length(),
                end.sub(testPoint).length());
        double distance = line.distanceTo(testPoint);
        
        assertTrue(VectorCompare.compare(distance, testResult));
    }
    
    @Test
    public void test_distanceTo_11() {
        Vector3d start = new Vector3d(0.0, 0.0, 0.0);
        Vector3d end = new Vector3d(2.0, 0.0, 0.0);
        Vector3d testPoint = new Vector3d(3.0, 4.0, 4.0);
        
        LineSegment line = new LineSegment(start, end);
        
        final double testResult = Math.min(start.sub(testPoint).length(),
                end.sub(testPoint).length());
        double distance = line.distanceTo(testPoint);
        
        assertTrue(VectorCompare.compare(distance, testResult));
    }
    
    @Test
    public void test_distanceTo_12() {
        Vector3d start = new Vector3d(0.0, 0.0, 0.0);
        Vector3d end = new Vector3d(0.0, 0.0, 3.0);
        Vector3d testPoint = new Vector3d(1.0, 0.0, -1.0);
        
        LineSegment line = new LineSegment(start, end);
        
        final double testResult = Math.min(start.sub(testPoint).length(),
                end.sub(testPoint).length());
        double distance = line.distanceTo(testPoint);
        
        System.out.println(testResult + " " + distance);
        
        assertTrue(VectorCompare.compare(distance, testResult));
    }
    
    @Test
    public void test_constructor_1() {
        Vector2d p1 = new Vector2d(0.0, 0.0);
        Vector2d p2 = new Vector2d(0.0, 0.0001);
        LineSegment line = new LineSegment(p1, p2);
    }
    
    @Test
    public void test_getDirectionVector_1() {
        Vector2d start = new Vector2d(0.0, 0.0);
        Vector2d end = new Vector2d(0.0, 0.0001);
        LineSegment line = new LineSegment(start, end);
        
        Vector2d realDirection = new Vector2d(0.0, 1.0);
        Vector2d direction = (Vector2d)line.getDirectionVector();
        
        assertTrue(VectorCompare.compare(direction, realDirection));
    }
    
    @Test
    public void test_getDirectionVector_2() {
        Vector2d start = new Vector2d(0.0, 0.0);
        Vector2d end = new Vector2d(0.0, 0.0000001);
        LineSegment line = new LineSegment(start, end);
        
        Vector2d realDirection = new Vector2d(0.0, 1.0);
        Vector2d direction = (Vector2d)line.getDirectionVector();
        
        assertTrue(VectorCompare.compare(direction, realDirection));
    }
    
    @Test
    public void test_getDirectionVector_3() {
        Vector2d start = new Vector2d(0.0, 0.0);
        Vector2d end = new Vector2d(0.000001, 0.0);
        LineSegment line = new LineSegment(start, end);
        
        Vector2d realDirection = new Vector2d(1.0, 0.0);
        Vector2d direction = (Vector2d)line.getDirectionVector();
        
        assertTrue(VectorCompare.compare(direction, realDirection));
    }
    
    @Test
    public void test_getDirectionVector_4() {
        Vector2d start = new Vector2d(0.000001, 0.0);
        Vector2d end = new Vector2d(0.0, 0.0);
        LineSegment line = new LineSegment(start, end);
        
        Vector2d realDirection = new Vector2d(-1.0, 0.0);
        Vector2d direction = (Vector2d)line.getDirectionVector();
        
        assertTrue(VectorCompare.compare(direction, realDirection));
    }
}
