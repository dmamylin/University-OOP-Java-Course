package lesson2;

public class Lesson2 {
    private static double distanceFromPointToLine(Vector3d linePoint1,
            Vector3d linePoint2, Vector3d point) {
        Vector3d lineDir = linePoint2.sub(linePoint1);
        
        // Находим площадь параллелограмма, построенного на векторах:
        // linePoint2 - linePoint1   и   point - linePoint2
        double area = lineDir.crossProduct(point.sub(linePoint1)).length();
        
        return area / lineDir.length();
    }
    
    public static void main(String args[]) {
        Vector3d testVec;
        
        SquareValidator sqValid = new SquareValidator();
        
        Vector3d linePoint1 = new Vector3d(0.0, 0.0, 0.0);
        Vector3d linePoint2 = new Vector3d(1.0, 0.0, 0.0);
        
        Vector3d linePoint3 = new Vector3d(0.0, 3.0, 0.0);
        Vector3d linePoint4 = new Vector3d(1.0, 3.0, 0.0);
        
        Vector3d point1 = new Vector3d(0.0, 1.0, 0.0);
        Vector3d point2 = new Vector3d(1.0, 1.0, 0.0);
        Vector3d point3 = new Vector3d(1.0, 0.0, 0.0);
        
        Vector3d point4 = new Vector3d(3.0, 0.0, 0.0);
        
        Vector3d point5 = new Vector3d(-2.0, -3.0, 0.0);
        Vector3d point6 = new Vector3d(-5.0, -6.0, 0.0);
        Vector3d point7 = new Vector3d(-2.0, -6.0, 0.0);
        
        System.out.println(distanceFromPointToLine(linePoint1, linePoint2, point1) +
                " must be " + 1.0);
        System.out.println(distanceFromPointToLine(linePoint1, linePoint2, point2) +
                " must be " + 1.0);
        System.out.println(distanceFromPointToLine(linePoint3, linePoint4, point4) +
                " must be " + 3.0);
        
        if (sqValid.pointsOnSquare(point3, point2, point1)) {
            testVec = sqValid.getFourthPoint();
            System.out.println("Points lie on the square. Result: " + testVec.toString());
        } else {
            System.out.println("Points not lie on the square.");
        }
        
        if (sqValid.pointsOnSquare(point1, point2, new Vector3d(2.0, 1.0, 3.0))) {
            testVec = sqValid.getFourthPoint();
            System.out.println("Points lie on the square. Result: " + testVec.toString());
        } else {
            System.out.println("Points not lie on the square.");
        }
        
        if (sqValid.pointsOnSquare(point5, point6, point7)) {
            testVec = sqValid.getFourthPoint();
            System.out.println("Points lie on the square. Result: " + testVec.toString());
        } else {
            System.out.println("Points not lie on the square.");
        }
    }
}
