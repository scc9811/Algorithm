import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int idx = -1;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'O') {
                idx = i;
            } else if (s.charAt(i) == '.') count++;
        }

        int left = 0;
        for (int i = idx - 1; i >= 0; i--) {
            if (s.charAt(i) == 'X') break;
            left++;
        }

        int right = 0;
        for (int i = idx + 1; i < n; i++) {
            if (s.charAt(i) == 'X') break;
            right++;
        }
        if (left > right) {
            int tmp = left;
            left = right;
            right = tmp;
        }

        int blank = count - (left + right);

        int res;
        // 0 : mingyu,  1 : yunsu,  2 : draw
        if (left == 0) {
//            if(right==0) res = 1;
//            else res = 0;
            res = 0;
        }
        else if (left == 1) {
            if (right == 1) {
                if (blank % 2 == 0) res = 1;
                else res = 0;
            }
            else{
                if((right + blank)%2==0) res = 0;
                else res = 2;
            }
        }
        else{
            res = 2;
        }
        


        if (res == 0) {
            System.out.println("mingyu");
        } else if (res == 1) {
            System.out.println("yunsu");
        } else {
            System.out.println("draw");
        }











    }
}