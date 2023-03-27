package comp354calc;

public class Standard_Deviation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static double standardDeviation(double avg, double[] values) {
		double result = 0;
		for(int i = 0; i < values.length; i++) {
			result += (values[i]-avg)*(values[i]-avg);
		}
		result = squareRoot(result)/values.length;
		return result;
	}
	
	
	public static double squareRoot(double x) {
		double val = x/2;
		double newVal;
		double error;
		do {
			newVal = 0.5*(val + x/val);
			error = (newVal - val);
			val = newVal;
		} while(error > 0.00001);
		return val;
	}

	public static double absVal(double x) {
		if(x < 0) {
			return x*-1;
		} else {
			return x;
		}
	}
	
	
}
