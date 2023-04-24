package figure.rectangle;
public class rectangle implements figure.figure {

    private double a;
    private double b;

    public rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }
    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public void getB() {

    }
    public void setB(double b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return String.format("Прямоугольник со сторонами a = %s, b = %s", a, b);
    }

    public  double getPerimeter() {
        return 2 * (a + b);
    }

    public double getArea() {
        return  a * b;
    }
}
