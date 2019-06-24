import java.util.Scanner;

public class CalcEquation {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        double a, b, c; //declaring coefficients of quadratic equation
        double d; //declaring discriminant
        System.out.printf("Solving a quadratic equation: a*x^2+b*x+c=0" + "\n");

        a = validateAndGet("a");
        b = validateAndGet("b");
        c = validateAndGet("c");

        /*
       calculating the roots
        */
        if (a == 0) {

            double x = solutionSimple(b, c);
            System.out.println("x = " + x);

        } else {
            d = discriminant(a, b, c);
            System.out.println("Discriminant:");
            System.out.println("d = " + d + "\n");

            System.out.println("Solution:");
            if (d > 0) {
                double[] result = solutionQuadratic(a, b, d);
                System.out.println("x1 = " + result[0]);
                System.out.println("x2 = " + result[1]);
            } else if (d == 0) {
                double x = solutionQuadratic(a, b);
                System.out.println("x = " + x);

            } else {
                System.out.print("The discriminant is less than zero. There are no real roots.");
            }
        }
    }

    /*
        Method that validates and gets a,b,c coefficients.
        If a,b,c not numbers than method return error.
    */
    private static double validateAndGet(String coeffName) {
        System.out.println("Enter coefficient '" + coeffName + "': ");
        while (!scanner.hasNextDouble()) {
            System.out.println("[ERROR] Coefficient '" + coeffName + "' must be a number!");
            System.out.println("Enter coefficient '" + coeffName + "': ");
            scanner.next();
        }
        return scanner.nextDouble();
    }

    /*
       Method that calculates discriminant
    */
    private static double discriminant(double a, double b, double c) {
        return Math.pow(b, 2) - (4 * a * c);
    }

    /*
        Method that calculates the roots of quadratic equation if discriminant > 0
    */
    private static double[] solutionQuadratic(double a, double b, double d) {
        double x1;
        double x2;
        x1 = (-b + Math.sqrt(d)) / (2 * a);
        x2 = (-b - Math.sqrt(d)) / (2 * a);
        return new double[]{x1, x2};
    }

    /*
        Method that calculates the root of quadratic equation if discriminant = 0
    */
    private static double solutionQuadratic(double a, double b) {
        return -b / 2 * a;
    }

    /*
        Method that calculates the root of  equation if coefficient a = 0 -> quadratic equation converts into equation b*x+c=0
    */
    private static double solutionSimple(double b, double c) {
        return -c / b;
    }
}