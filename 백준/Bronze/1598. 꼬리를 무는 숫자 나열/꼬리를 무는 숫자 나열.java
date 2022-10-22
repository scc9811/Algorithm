import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());

        if(n1 < n2){
            int tmp=n1;
            n1 = n2;
            n2 = tmp;
        }



        // 동서

        int ew1, ew2, ns1, ns2;
        if(n1%4==0){
            ew1 = n1/4-1;
            ns1 = 4;
        }
        else{
            ew1 = n1/4;
            ns1 = n1%4;
        }

        if(n2%4==0){
            ew2 = n2/4-1;
            ns2 = 4;
        }
        else{
            ew2 = n2/4;
            ns2 = n2%4;
        }

        System.out.println(ew1-ew2 + Math.abs(ns1-ns2));










    }
}