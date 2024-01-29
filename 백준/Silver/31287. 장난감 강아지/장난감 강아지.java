import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = 0;
        int y = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String s = br.readLine();

        if(k==1){
            for(int i=0; i<n; i++){
                if(s.charAt(i)=='U'){
                    y++;
                }
                else if(s.charAt(i)=='D'){
                    y--;
                }
                else if(s.charAt(i)=='L'){
                    x--;
                }
                else{
                    x++;
                }
                if(x==0 && y==0){
                    System.out.println("YES");
                    System.exit(0);
                }
            }
            System.out.println("NO");
        }
        else{
            for(int j=0; j<Math.min(k, 1000); j++) {
                for (int i = 0; i < n; i++) {
                    if (s.charAt(i) == 'U') {
                        y++;
                    } else if (s.charAt(i) == 'D') {
                        y--;
                    } else if (s.charAt(i) == 'L') {
                        x--;
                    } else {
                        x++;
                    }
                    if (x == 0 && y == 0) {
                        System.out.println("YES");
                        System.exit(0);
                    }
                }
            }
            System.out.println("NO");




        }


















    }
}