package Day1;

import java.util.Scanner;

public class ArithmeticOperators {
	public static void main(String args[]){
	
		Scanner s = new Scanner(System.in);
		System.out.println("Enter a and b value :\n");
		int a = s.nextInt();
		int b = s.nextInt();
		System.out.println("Sum : "+(a+b));
		System.out.println("Difference :"+(a-b));
		System.out.println("Product :"+(a*b));
		System.out.println("Quotient :"+(a/b));
		System.out.println("Remainder :"+(a%b));
	}
}
