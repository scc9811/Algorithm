import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(testCase-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int sum = 0;
            if(n1>21) sum=0;
            else if(n1>15) sum=100000;
            else if(n1>10) sum=300000;
            else if(n1>6) sum=500000;
            else if(n1>3) sum=2000000;
            else if(n1>1) sum=3000000;
            else if(n1==1) sum=5000000;

            if(n2>31) sum+=0;
            else if(n2>15) sum+=320000;
            else if(n2>7) sum+=640000;
            else if(n2>3) sum+=1280000;
            else if(n2>1) sum+=2560000;
            else if(n2==1) sum+=5120000;
            sb.append(sum).append('\n');
        }
        System.out.println(sb);











    }
}