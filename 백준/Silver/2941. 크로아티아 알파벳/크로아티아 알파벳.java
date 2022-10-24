import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String s = input.next();
		int count = s.length();

		for (int i=0; i <s.length(); i++) {
			if (i>0) {
				if(s.charAt(i)=='=') {
					if(s.charAt(i-1)=='c' || 
							s.charAt(i-1)=='s' || s.charAt(i-1)=='z') {
						count--;
						if(i>1) {
							if(s.charAt(i-1)=='z' && s.charAt(i-2)=='d') {
								count --;
							}
						}
					}
				}
				if(s.charAt(i)=='-') {
					if(s.charAt(i-1)=='c' || s.charAt(i-1)=='d') {
						count--;
					}
				}
				if(s.charAt(i)=='j') {
					if(s.charAt(i-1)=='l'||s.charAt(i-1)=='n') {
						count--;
					}
				}
			}
		}


		System.out.println(count);
		input.close();

	}



}