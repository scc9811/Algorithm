import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int left = Integer.parseInt(st.nextToken());
        int right = Integer.parseInt(st.nextToken());
        boolean isLeftValid = true;
        boolean isRightValid = true;
        if(left!=0 && left!=2 && left!=5) isLeftValid = false;
        if(right!=0 && right!=2 && right!=5) isRightValid = false;

        // 0:draw, 1:a, 2:b
        int resFlag = 0;

        if(!isLeftValid && isRightValid) {
            resFlag = 2;
        }
        if(isLeftValid && !isRightValid) {
            resFlag = 1;
        }



        if(left == 0) {
            if(right == 2) resFlag = 1;
            else if(right == 5) resFlag = 2;
        }
        else if(left == 2) {
            if(right == 0) resFlag = 2;
            else if(right == 5) resFlag = 1;
        }
        else if(left == 5) {
            if(right == 0) resFlag = 1;
            else if(right == 2) resFlag = 2;
        }

        if(resFlag == 0) {
            System.out.println("=");
        }
        else if(resFlag == 1) {
            System.out.println(">");
        }
        else {
            System.out.println("<");
        }











    }
}