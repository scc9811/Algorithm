import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        char[] arr = br.readLine().toCharArray();
        if(h>=4) {
            if(n>=4) System.out.println(-1);
            else {
                int a =0;
                int b = 0;
                int c = 0;
                for(int i=0; i<n; i++){
                    if(arr[i] == 'S') a++;
                    else if(arr[i] == 'R') b++;
                    else c++;
                }
                int res = 0;
                if(a>1) res += a-1;
                if(b>1) res += b-1;
                if(c>1) res += c-1;
                System.out.println(res);
            }
            System.exit(0);
        }
        else if(h==1) System.out.println(0);
        else if(h==2){
            int res = 0;
            for(int i=1; i<n; i++){
                if(arr[i-1] == arr[i]){
                    res++;
                    if(i==n-1) continue;
                    if(arr[i-1] == 'S'){
                        if(arr[i+1] == 'R') arr[i] = 'W';
                        else if(arr[i+1] == 'W') arr[i] = 'R';
                        else arr[i] = 'W';
                    }
                    else if(arr[i-1] == 'R'){
                        if(arr[i+1] == 'S') arr[i] = 'W';
                        else if(arr[i+1] == 'W') arr[i] = 'S';
                        else arr[i] = 'W';
                    }
                    // 'W'
                    else{
                        if(arr[i+1] == 'R') arr[i] = 'S';
                        else if(arr[i+1] == 'S') arr[i] = 'R';
                        else arr[i] = 'S';
                    }
                }
            }
            System.out.println(res);
        }
        else if(h==3){
            // 'swr'
            char[] arr1 = {'S', 'W', 'R'};
            char[] arr2 = {'S', 'R', 'W'};
            int min = (int)1e9;

            //arr1
            for(int pointer=0;  pointer<3; pointer++){
                int count = 0;
//                System.out.println("pointer = "+pointer);
                int tmpP = pointer;
                for(int i=0; i<n; i++){
                    if(arr[i] != arr1[tmpP]) count++;
//                    if(arr[i] != arr1[tmpP]) System.out.println("diff I = "+i);
                    tmpP = (tmpP+1)%3;
                }
//                System.out.println("count = "+count);
                min = Math.min(min, count);
            }

            //arr2
            for(int pointer=0;  pointer<3; pointer++){
                int count = 0;
                int tmpP = pointer;
                for(int i=0; i<n; i++){
                    if(arr[i] != arr2[tmpP]) count++;
                    tmpP = (tmpP+1)%3;
                }
//                System.out.println("count = "+count);
                min = Math.min(min, count);
            }
            System.out.println(min);
        }















    }
    static long gcd(long a, long b){
        if(b==0) return a;
        return gcd(b, a%b);
    }
}