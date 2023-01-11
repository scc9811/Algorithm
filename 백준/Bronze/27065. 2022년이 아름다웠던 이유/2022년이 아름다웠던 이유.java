import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
//        // 과잉수인 경우 : -1, 아직방문X : 0 , 부족/완전수 : 1.
        int[] arr = new int[5001];
        for(int i=1; i<=5000; i++){
            int sum = 1;
            for(int j=2; j*j<=i; j++){
                if(i%j==0){
                    sum += (j+i/j);
                }
                if(j*j==i) sum -= j;
            }
            if(sum > i) arr[i] = -1;
            else arr[i] = 1;
        }


        while(testCase-->0){
            int n = Integer.parseInt(br.readLine());
            boolean tf = true;
            if(arr[n]!=-1){
                tf = false;
            }
            else{
                for(int i=2; i*i<=n; i++){
                    if(n%i==0) {
                        if (arr[i] != 1 || arr[n/i] !=1 ) {
                            tf = false;
                            break;
                        }
                    }
                }
            }
            if(tf) sb.append("Good Bye");
            else sb.append("BOJ 2022");
            sb.append('\n');
        }
        System.out.println(sb);





    }
}