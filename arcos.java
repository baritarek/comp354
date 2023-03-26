
public class arcos {

    public static double semifactorial(int x) throws Error {
        if (x < 0)
            throw new Error("MATH ERROR");

        int result = 1;
        while (x > 0) {
            result *= x;
            x -= 2;
        }
        return result;
    }

    public static double arccosine(double x) throws Error {
        if (x < -1 || x > 1)
            throw new Error("MATH ERROR");

        if (x == 0)
            return (DegreeRadian.isRadian ? Math.PI / 2 : DegreeRadian.radianToDegree(Math.PI / 2));
        else if (x == 1)
            return 0;
        else if (x == -1)
            return (DegreeRadian.isRadian ? Math.PI : DegreeRadian.radianToDegree(Math.PI));

        // Taylor Series (14th approximation)
        double result = x;

        for (int n = 1; n < 14; n++) {
            result += (semifactorial(2 * n - 1) / semifactorial(2 * n)) * (exponential(1, x, 2 * n + 1) / (2 * n + 1));
        }

        return (DegreeRadian.isRadian ? Math.PI / 2 - result : DegreeRadian.radianToDegree((Math.PI / 2 - result)));

    }

    private static double ln(double x) {
        double old_sum = 0.0;
        double denominator = 1.0;
        double y = (x - 1) / (x + 1);
        double y2 = y * y;
        double sum = y;

        while (sum != old_sum) {
            old_sum = sum;
            denominator += 2.0;
            y *= y2;
            sum += y / denominator;
        }
        return 2.0 * sum;
    }

    public static double power_intPositiveExponent(double base, int x) {
        double result = base;

        if (x == 1)
            return result;
        else {
            for (int i = 2; i <= x; i++) {
                result = result * base;
            }
            return result;
        }
    }

    private static double factorial(int n) {
        if (n == 0)
            return 1;
        else {
            return n * factorial(n - 1);
        }
    }

    private static double natural_exponential(double x) {
        double result = 1;
        int loop = 100;
        int start = 1;

        while (start <= loop) {
            result += power_intPositiveExponent(x, start) / factorial(start);
            start++;
        }
        return result;
    }

    public static double exponential(double a, double b, double x) throws Error {
        Double result = 0.0;

        if (b >= 0)
            result = a * natural_exponential(x * ln(b));
        else
            result = a * Math.pow(b, x);

        if (result.isNaN())
            throw new Error("MATH ERROR");
        else
            return result;
    }

    public static void main(String[] args) {
        System.out.println("hellooo ");
        System.out.println(arccosine(0.4));

    }
}
