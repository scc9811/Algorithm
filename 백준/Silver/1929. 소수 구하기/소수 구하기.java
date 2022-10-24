import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();
        if (start<2) start =2 ;

        while (start <= end){
            boolean tf = true;
            for(int i=2; i*i<=start; i++){
                if(start%i==0){
                    tf = false;
                    break;
                }
            }
            if (tf==true) System.out.println(start);
            start++;
        }

    }
}
