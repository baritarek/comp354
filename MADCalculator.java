public class MADCalculator {

    public static double calculateMAD(double[] numbers) {
        double mean = calculateMean(numbers);
        double[] deviations = new double[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            deviations[i] = Math.abs(numbers[i] - mean);
        }
        double mad = calculateMean(deviations);
        return mad;
    }

    private static double calculateMean(double[] numbers) {
        double sum = 0;
        for (double number : numbers) {
            sum += number;
        }
        double mean = sum / numbers.length;
        return mean;
    }

    public static void main(String[] args) {
        double[] numbers = {2,3,7,8, 1.4, 5.6, 9.9, 21};
        double mad = calculateMAD(numbers);
        System.out.println("The Mean Absolute Deviation of the numbers is: " + mad);
    }
}
