import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String tmpX = st.nextToken();
        double x = Double.parseDouble(tmpX);
        StringTokenizer tmpSt = new StringTokenizer(tmpX, ".");
        int intX = Integer.parseInt(tmpSt.nextToken())*100 + Integer.parseInt(tmpSt.nextToken());
        double sum = 0;
        int intSum = 0;
        int weightSum = 0;
        for(int i=0; i<n-1; i++){
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            weightSum += weight;
            String s = st.nextToken();
            double cur;
            int intCur;
            if(s.equals("A+")){
                cur = 4.5;
                intCur = 450;
            }
            else if(s.equals("A0")){
                cur = 4.0;
                intCur = 400;
            }
            else if(s.equals("B+")){
                cur = 3.5;
                intCur = 350;
            }
            else if(s.equals("B0")){
                cur = 3.0;
                intCur = 300;
            }
            else if(s.equals("C+")){
                cur = 2.5;
                intCur = 250;
            }
            else if(s.equals("C0")){
                cur = 2.0;
                intCur = 200;
            }
            else if(s.equals("D+")){
                cur = 1.5;
                intCur = 150;
            }
            else if(s.equals("D0")){
                cur = 1.0;
                intCur = 100;
            }
            else if(s.equals("F")){
                cur = 0.0;
                intCur = 0;
            }
            else{
                System.out.println("ERROR");
                cur = 500;
                intCur = 500;
            }
            sum += weight * cur;
            intSum += weight * intCur;
//            System.out.println("sum = "+sum);
        }

        int weight = Integer.parseInt(br.readLine());
        weightSum += weight;
        double[] arr = {0, 1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0, 4.5};
        int[] intArr = {0, 100, 150, 200, 250, 300, 350, 400, 450};
        String[] sArray = {"F", "D0", "D+", "C0", "C+", "B0", "B+", "A0", "A+"};

//        System.out.println("WeightSum = "+weightSum);
//        System.out.println("sum = "+sum);
//        System.out.println("/"+  5050/14);

//        if(sum/weightSum > x){
//            System.out.println("F");
//            System.exit(0);
//        }

        for(int i=0; i<9; i++){
//            System.out.println("~~ = "+(intSum + weight * intArr[i])/weightSum);
            if((intSum + weight * intArr[i])%weightSum == 0){
                if((intSum + weight * intArr[i])/weightSum > intX){
                    System.out.println(sArray[i]);
                    System.exit(0);
                }
            }
            else{
                double tmpSum = (sum + weight * arr[i]) / weightSum;
                tmpSum = Math.floor(tmpSum * 100) / 100;
                if (tmpSum > x) {
                    System.out.println(sArray[i]);
                    System.exit(0);
                }
            }
        }
        System.out.println("impossible");


















    }
    static long gcd(long a, long b){
        if(b==0) return a;
        return gcd(b, a%b);
    }
}