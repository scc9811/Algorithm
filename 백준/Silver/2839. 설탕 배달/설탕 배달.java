import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int fiveCount = 0;
        int threeCount = 0;
        input.close();

        fiveCount = n/5;
        if (n%5 ==0) System.out.println(fiveCount);
        else{

            boolean B = false;
            while(fiveCount>=0){
                threeCount = (n - fiveCount*5)/3;
                if ( (fiveCount*5 + threeCount*3) == n ){
                    System.out.println(fiveCount+threeCount);
                    B = true;
                    break;
                }
                fiveCount--;


            }
            if (B==false) System.out.println(-1);

        }
    }
}
