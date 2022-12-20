import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String s = st.nextToken();
        // 65 90  97
        if(n==1){
            System.out.println(s);


            StringBuilder sb = new StringBuilder();
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i)>=65 && s.charAt(i)<=90) sb.append('_').append((char)(s.charAt(i)+32));
                else sb.append(s.charAt(i));
            }
            System.out.println(sb);


            sb = new StringBuilder();
            sb.append((char)(s.charAt(0)-32));
            for(int i=1; i<s.length(); i++){
                sb.append(s.charAt(i));
            }
            System.out.println(sb);
        }
        else if(n==2){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i)=='_') {
                    sb.append((char)(s.charAt(++i)-32));
                }
                else sb.append(s.charAt(i));
            }
            System.out.println(sb);
            System.out.println(s);
            sb.delete(0,1);
            sb.insert(0,(char)(s.charAt(0)-32));
            System.out.println(sb);
        }
        else if(n==3){
            StringBuilder sb = new StringBuilder(s);
            sb.delete(0,1);
            sb.insert(0, (char)(s.charAt(0)+32));
            System.out.println(sb);


            sb = new StringBuilder();
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i)>=65 && s.charAt(i)<=90) sb.append('_').append((char)(s.charAt(i)+32));
                else sb.append(s.charAt(i));
            }
            sb.delete(0,1);
            System.out.println(sb);


            System.out.println(s);
        }















    }
}

