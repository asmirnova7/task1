package figure.triangle;
import java.util.Comparator;

import static java.lang.Math.sin;

public abstract class triangle implements Comparable<triangle> {
    private double a;
    private  double b;
    private double angle;

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public triangle(double a, double b, double angle) {
        this.a = a;
        this.b = b;
        this.angle = angle;
    }

    public  abstract  double getPerimeter();

    public double getArea() {
        return  0.5 * a * b * sin(Math.toRadians(angle));
    }

    @Override
    public String toString() {
        return String.format("Треугольник со сторонами a = %s, b = %s и <ab = %s", a, b, angle);
    }

    @Override
    public int compareTo(triangle someTriangle) {
        if  (this.getPerimeter() == someTriangle.getPerimeter()) {
            return 0;
        }
        else if (this.getPerimeter() > someTriangle.getPerimeter()) {
            return 1;
        }
        else return -1;
    }

    public static class triangleComparator implements Comparator<triangle> {

        @Override
        public int compare(triangle triangle1, triangle triangle2) {
            if  (triangle1.getArea() == triangle2.getArea()) {
                return 0;
            }
            else if (triangle1.getArea() > triangle2.getArea()) {
                return 1;
            }
            else return -1;
        }
    }
}