import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(testCase-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int res = 0;

            while(true){
                if(a*3 <= b && a*4 >= b) break;
                if(a*3 > b){
                    res++;
                    b++;
                }
                else if(a*4 < b){
                    res++;
                    a++;
                }
            }
            sb.append(res).append('\n');


//            int l = a * 3;
//            int r = a * 4;
//            int res;
//            if(b < l){
//                res = l-b;
//            }
//            else if(b >= l && b <= r){
//                res = 0;
//            }
//            else{
//                res = 0;
//                while(r + res*4 < b){
//                    res++;
//                }
////                if(r + res*4 - b == 3){
////                    res++;
////                }
//                if((a + res) * 3 > b){
//                    res++;
//                }
//            }
//            sb.append(res).append('\n');












        }
        System.out.println(sb);















    }
}