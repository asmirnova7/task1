package figure.triangle;
import static java.lang.Math.sin;

public abstract class triangle {
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
}
