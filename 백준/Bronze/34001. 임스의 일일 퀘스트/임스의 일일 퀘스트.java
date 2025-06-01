
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] arr1 = {200, 210, 220, 225, 230, 235};
        int[] arr2 = {210, 220, 225, 230, 235, 245};
        int[] arr3 = {220, 225, 230 ,235, 245, 250};

        for (int i=0; i<6; i++) {
            int res = 0;
            if (n >= arr1[i]) res = 500;
            if (n >= arr2[i]) res = 300;
            if (n >= arr3[i]) res = 100;
            sb.append(res).append(' ');
        }
        sb.append('\n');
        int[] a1 = {260, 265, 270, 275, 280, 285, 290};
        int[] a2 = {265, 270, 275, 280, 285, 290, 295};
        int[] a3 = {270, 275, 280, 285, 290, 295, 300};

        for (int i=0; i<7; i++) {
            int res = 0;
            if (n >= a1[i]) res = 500;
            if (n >= a2[i]) res = 300;
            if (n >= a3[i]) res = 100;
            sb.append(res).append(' ');
        }

        System.out.println(sb);







    }
}