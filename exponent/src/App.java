import java.util.Scanner;

import javax.xml.transform.Source;

import io.github.mrrefactoring.Fraction;

public class App {
    public static void main(String[] args) throws Exception {
        double x, y;

        Scanner scan = new Scanner(System.in);
        System.out.print("value of x: ");
        x = scan.nextDouble();
        System.out.print("value of y: ");
        y = scan.nextDouble();
        System.out.println(power(x, y));
        scan.close();
    }


    public static double power(double base, double exponent) {
        if (exponent == 0.0) {
            return 1.0;
        }
        
        double result = 1.0;
        double absExponent = exponent < 0 ? -exponent : exponent;
        String numString = String.valueOf(exponent);
        int indexOfDecimal = numString.indexOf(".");
        double decimal =  Double.parseDouble(numString.substring(indexOfDecimal));
        System.out.println("DEBUG: decimal part " + decimal);

        
        for (int i = 1; i <= absExponent; i++) {
            result *= base;
        }

        if (decimal != 0.0)
        {
            try {
                Fraction frac = new Fraction(base);
                System.out.println("DEBUG: fraction " + frac.toFraction());
                System.out.println("DEBUG: power with fraction " + frac.pow(decimal)); 
                result *= frac.pow(decimal).toDecimal();
            } catch (Exception e) {
                System.out.println("ERROR - DIVISION BY ZERO");
                System.exit(0);
            }
            
        }
        
        if (exponent < 0.0) {
            result = 1.0 / result;
        }
        
        // System.out.println(base + "^" + exponent + " = " + result);
        return result;
    }

}
