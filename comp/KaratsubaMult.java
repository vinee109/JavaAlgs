/* KaratsubaMult.java */
package comp;

/**
*	This class performs Karatsuba Multiplication on two n-digit numbers. 
**/
public class KaratsubaMult{
	
	public KaratsubaMult(){
	}

	private static int getFirstHalf(int num){
		String str = String.valueOf(num);
		return Integer.parseInt(str.substring(0, str.length()/2));
	}

	private static int getSecondHalf(int num){
		String str = String.valueOf(num);
		return Integer.parseInt(str.substring(str.length()/2));
	}
	
	public static int multiply(int num1, int num2){
		int n = String.valueOf(num1).length();		// number of digits in both numbers
		int nBy2;
		if (n % 2 == 0){
			nBy2 = n/2;
		} else{
			nBy2 = n/2 + 1;
		}
		if (num1 < 10 || num2 < 10){
			return num1 * num2;
		}
		// breaking up each number into two halves
		int a = getFirstHalf(num1), b = getSecondHalf(num1);
		int c = getFirstHalf(num2), d = getSecondHalf(num2);
		
		int firstSum = multiply(a, c);
		int secondSum = multiply(b, d);
		int thirdSum = multiply(a+b, c+d);

		return (int)Math.pow(10, nBy2 + nBy2) * firstSum + secondSum + ((int)Math.pow(10, nBy2))*(thirdSum - (firstSum + secondSum));
		
	}
}
