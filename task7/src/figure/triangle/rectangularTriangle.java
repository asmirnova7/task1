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
}
