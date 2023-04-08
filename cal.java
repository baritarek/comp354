public static double log(double x, double base) throws Error {
    if (x <= 0 || base <= 0 || base == 1)
        throw new Error();
    return ln(x) / ln(base);
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

/**
 * Common logarithm (base 10)
 * 
 * @param x real number
 * @return real number
 */
public static double log(double x) throws Error {
    return log(x, 10);
}


System.out.println(log(10));