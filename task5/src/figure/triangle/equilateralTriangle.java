package figure.triangle;

import static java.lang.Math.sqrt;

public class equilateralTriangle extends triangle{

    private double c;

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public equilateralTriangle(double a, double b, double angle) {
        super(a, b, angle);
        c = a;
    }

    public  double getPerimeter() {
        return super.getA() + super.getB() + super.getA();
    }

    @Override
    public String toString() {
        return String.format("Равносторонний треугольник со сторонами a = %s, b = %s и с = %s", super.getA(), super.getA(), super.getA());
    }
}
