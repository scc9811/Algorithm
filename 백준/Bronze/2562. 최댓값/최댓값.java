import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int Hello[] = new int[9];
		for (int i =0; i < Hello.length; i++) {
			Hello[i] = input.nextInt();
		}
		
		
		
		int Max = Hello[0];
		int k = 0;
		for (int i =0; i <Hello.length; i++) {
			if(Hello[i] > Max) {
				Max = Hello[i];
				k = i;
			}
		}
		System.out.println(Max);
		System.out.println(k+1);
		input.close();
		
	}

}
