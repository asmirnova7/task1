package figure.triangle;
import static java.lang.Math.sqrt;
public class rectangularTriangle extends triangle {
    public rectangularTriangle(double a, double b, double angle) {
        super(a, b, angle);
    }

    public  double getPerimeter() {
        return sqrt(super.getA() * super.getA() + super.getB() * super.getB()) + (super.getA() + super.getB());
    }

    @Override
    public String toString() {
        return String.format("Прямоугольный треугольник со сторонами a = %s, b = %s и <ab = %s", super.getA(), super.getB(), super.getAngle());
    }
}
