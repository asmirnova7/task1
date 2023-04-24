import figure.rectangle.*;
import figure.triangle.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите стороны прямоугольника");
        System.out.printf("a = ");
        double a = scanner.nextDouble();
        System.out.printf("b = ");
        double b = scanner.nextDouble();

        rectangle rect = new rectangle(a, b);

        System.out.println(rect.toString());
        System.out.println(String.format("Периметр прямоугольника = %s", rect.getPerimeter()));
        System.out.println(String.format("Площадь прямоугольника = %s", rect.getArea()));

        System.out.println("Введите стороу квадрата");
        System.out.printf("x = ");
        double x = scanner.nextDouble();

        box square = new box(x, x);

        System.out.println(String.format("Периметр квадрата = %s", square.getPerimeter()));
        System.out.println(String.format("Площадь квадрата = %s", square.getArea()));

        System.out.println("Введите катеты прямоугольного треугольника");
        System.out.printf("m = ");
        double m = scanner.nextDouble();

        System.out.printf("n = ");
        double n = scanner.nextDouble();

        rectangularTriangle rectTriangle = new rectangularTriangle(m,n,90);

        System.out.println(String.format("Периметр прямоугольного треугольника = %s", rectTriangle.getPerimeter()));
        System.out.println(String.format("Площадь прямоугольного треугольника = %s", rectTriangle.getArea()));

        System.out.println("Введите катет равностороннего треугольника");
        System.out.printf("k = ");
        double k = scanner.nextDouble();

        equilateralTriangle eqTriangle = new equilateralTriangle(k,k,60);

        System.out.println(String.format("Периметр равностороннего треугольника = %s", eqTriangle.getPerimeter()));
        System.out.println(String.format("Площадь равностороннего треугольника = %s", eqTriangle.getArea()));
    }
}