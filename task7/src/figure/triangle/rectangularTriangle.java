package figure.triangle;
import static java.lang.Math.sqrt;
public class rectangularTriangle extends triangle  {
    public rectangularTriangle(double a, double b)
    {
        super(a, b, 90);
    }

    public  double getPerimeter() {
        return sqrt(super.getA() * super.getA() + super.getB() * super.getB()) + (super.getA() + super.getB());
    }

    @Override
    public String toString() {
        return String.format("Прямоугольный треугольник со сторонами a = %s, b = %s, периметр %.3f, площадь %.3f",
                super.getA(),
                super.getB(),
                getPerimeter(),
                super.getArea());
    }
}
