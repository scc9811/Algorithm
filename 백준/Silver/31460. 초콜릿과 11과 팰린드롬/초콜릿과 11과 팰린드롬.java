import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(testCase-->0){
            int n = Integer.parseInt(br.readLine());
            if(n==1) sb.append(0);
            else if(n%2==0){
                for(int i=0; i<n; i++){
                    sb.append(1);
                }
            }
            else{
                if(n%4==1){
                    for(int i=0; i<n/2; i++){
                        sb.append(1);
                    }
                    sb.append(0);
                    for(int i=0; i<n/2; i++){
                        sb.append(1);
                    }
                }
                else{
                    for(int i=0; i<n/2; i++){
                        sb.append(1);
                    }
                    sb.append(2);
                    for(int i=0; i<n/2; i++){
                        sb.append(1);
                    }
                }
            }
            sb.append('\n');







        }

        System.out.println(sb);

















    }
}