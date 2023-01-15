import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int time = 1;
        // 1 정방향 -1 역방향
        int direction = 1;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int k = Integer.parseInt(st.nextToken());
            if(s.equals("HOURGLASS")){
                if(time==k) {
                    sb.append(time).append(' ').append("NO");
                }
                else{
                    sb.append(time).append(' ').append("NO");
                    direction = -direction;
                }
            }
            else{
                if(time==k){
                    sb.append(time).append(' ').append("YES");
                }
                else{
                    sb.append(time).append(' ').append("NO");
                }
            }
            if(direction==1) time++;
            else if(direction==-1) time--;
            if(time==13) time=1;
            else if(time==0) time = 12;
            sb.append('\n');
        }
        System.out.println(sb);










    }
}

