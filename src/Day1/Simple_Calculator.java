package Day1;

import java.util.Scanner;

public class Simple_Calculator {
	public static void main(String[] args){
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter two numbers :");
		int a = s.nextInt();
		int b = s.nextInt();
		System.out.println("Enter Your Operation:");
		System.out.println("______________________");
		System.out.println(" 1) + \n 2) - \n 3) * \n 4) / \n 5) %");
		System.out.println("______________________");
		int op = s.nextInt();		
		switch(op)
		{
		case '1':
			System.out.println("Sum :"+(a+b));
			break;
		case '2':
			System.out.println("Difference :"+(a-b));
			break;
		case '3':
			System.out.println("Product :"+(a*b));
			break;
		case '4':
			System.out.println("Quotient :"+(a/b));
			break;
		case '5':
			System.out.println("Remainder :"+(a%b));
			break;
		default:
			System.out.println("Invalid Operation");
		}
}
}