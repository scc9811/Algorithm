import java.util.Scanner;
public class Main {
	

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int N = input.nextInt();
		int Hello[] = new int[N];
		for (int i =0; i < Hello.length; i++) {
			int k = input.nextInt();
			Hello[i] = k;
		}
		
		
		input.close();
		int min = Hello[0];
		int max = Hello[0];
		
		
		for (int i =1; i< Hello.length; i++) {
			if (Hello[i] < min) {
				min = Hello[i];
			}
			if (Hello[i] > max) {
				max = Hello[i];
			}
			
		}
		
		System.out.printf("%d %d\n",min, max);

		
		
	}
	
}
