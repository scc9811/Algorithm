import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n =Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        if(n%2==0){
            for(int i=1; i<n; i+=2){
                sb.append(i).append(' ');
            }
            for(int i=n; i>=2; i-=2){
                sb.append(i).append(' ');
            }
            sb.append('\n');
        }
        else{
            for(int i=1; i<n; i+=2){
                sb.append(i).append(' ');
            }
            sb.append(n).append(' ');
            for(int i=n-1; i>=2; i-=2){
                sb.append(i).append(' ');
            }
            sb.append('\n');



        }
        System.out.println(sb);

















    }
    static int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b, a%b);
    }
    static int lcm(int x, int y){
        return x*y / gcd(x, y);
    }
}