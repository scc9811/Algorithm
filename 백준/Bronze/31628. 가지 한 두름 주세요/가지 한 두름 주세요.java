import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[][] arr = new String[10][10];
        for(int i=0; i<10; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<10; j++){
                arr[i][j] = st.nextToken();
            }
        }
        loop:
        for(int i=0; i<10; i++) {
            for (int j = 1; j < 10; j++) {
                if(!arr[i][0].equals(arr[i][j])) continue loop;
            }
            System.out.println(1);
            System.exit(0);
        }

        loop2:
        for(int j=0; j<10; j++){
            for(int i=1; i<10; i++){
                if(!arr[0][j].equals(arr[i][j])) continue loop2;
            }
            System.out.println(1);
            System.exit(0);
        }

        System.out.println(0);


















    }
}