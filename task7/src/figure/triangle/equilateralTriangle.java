package figure.triangle;

import static java.lang.Math.sqrt;

public class equilateralTriangle extends triangle {
    private double c;

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public equilateralTriangle(double a) {
        super(a, a, 60);
        c = a;
    }

    public  double getPerimeter() {
        return super.getA() + super.getB() + super.getA();
    }

}
