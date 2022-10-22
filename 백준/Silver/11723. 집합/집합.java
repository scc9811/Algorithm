import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        int[] array = new int[21];
        StringBuilder sb = new StringBuilder();
        while(testCase-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if(s.equals("add")){
                array[Integer.parseInt(st.nextToken())]=1;
            }
            else if(s.equals("check")){
                sb.append(array[Integer.parseInt(st.nextToken())]).append('\n');
            }
            else if(s.equals("remove")){
                array[Integer.parseInt(st.nextToken())]=0;
            }
            else if(s.equals("toggle")){
                int tmp = Integer.parseInt(st.nextToken());
                if(array[tmp]==1) array[tmp]=0;
                else array[tmp]=1;
            }
            else if(s.equals("empty")){
                for(int i=1; i<=20; i++){
                    array[i] = 0;
                }
            }
            else if(s.equals("all")){
                for(int i=1; i<=20; i++){
                    array[i] = 1;
                }
            }






        }
        System.out.println(sb);















    }
}