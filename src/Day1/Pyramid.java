package Day1;  
public class Pyramid {
	public static void main(String[] args) {
		for(int i=0;i<=5;i++) {
			System.out.print("");
			for(int sp=0; sp<=(5-i);sp++) {
				System.out.print(" ");
			}
			for(int j=0;j<(2*i-1);j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}

}
