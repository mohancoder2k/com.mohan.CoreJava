package Class_Objects;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		Method m = new Method();
		Scanner s = new Scanner(System.in);
		int op,result,num1,num2;
		System.out.println("Enter Two Numbers :");
		num1 = s.nextInt();
		num2= s.nextInt();
		System.out.println("---------------------");
		System.out.println(" 1)Sum \n 2)Difference \n 3)Product \n 4)Divider \n 5) Remainder");
		System.out.println("Enter your option :\n");
		op=s.nextInt();
		switch(op)
		{
		case '1':
				result = m.add(num1, num2);
				System.out.println(result);
				break;
			
		}
				
		
	}

}
