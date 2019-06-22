import java.util.Scanner;

public class CalcEquation {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        double a, b, c, d;

        System.out.printf("Solving a quadratic equation: a*x^2+b*x+c=0" + "\n");

        a = validateAndGet("a");
        b = validateAndGet("b");
        c = validateAndGet("c");

        if (a == 0) {

            double x = solutionSimple(b, c);
            System.out.println("x = " + x);

        } else {
            d = discriminant(a, b, c);
            System.out.println("Discriminant:");
            System.out.println("d = " + d + "\n");

            System.out.println("Solution:");
            if (d > 0) {
                double[] result = solutionQudratic(a, b, d);
                System.out.println("x1 = " + result[0]);
                System.out.println("x2 = " + result[1]);
            } else if (d == 0) {
                double x = solutionQudratic(a, b);
                System.out.println("x = " + x);

            } else {
                System.out.print("The discriminant is less than zero. There are no real roots.");
            }
        }
    }

    private static double validateAndGet(String coeffName) {
        System.out.println("Enter coefficient '" + coeffName + "': ");
        while (!scanner.hasNextDouble()) {
            System.out.println("[ERROR] Coefficient '" + coeffName + "' must be a number!");
            System.out.println("Enter coefficient '" + coeffName + "': ");
            scanner.next();
        }
        return scanner.nextDouble();
    }

    private static double discriminant(double a, double b, double c) {
        return Math.pow(b, 2) - (4 * a * c);
    }

    private static double[] solutionQudratic(double a, double b, double d) {
        double x1;
        double x2;
        x1 = (-b + Math.sqrt(d)) / (2 * a);
        x2 = (-b - Math.sqrt(d)) / (2 * a);
        return new double[]{x1, x2};
    }

    private static double solutionQudratic(double a, double b) {
        return -b / 2 * a;
    }

    private static double solutionSimple(double b, double c) {
        return -c / b;
    }
}