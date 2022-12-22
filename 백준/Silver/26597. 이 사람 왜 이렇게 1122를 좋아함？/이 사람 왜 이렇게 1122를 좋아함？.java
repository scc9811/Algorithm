import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine());
        long left = (long) -1e18-1;
        long right = (long) 1e18+1;
        int tf = 0;
        // -1:false, 0:hmm, 1:true;
        int key = 111224;
        for(int i=0; i<q; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            // up
            if(st.nextToken().charAt(0)=='^'){
                left = Math.max(left, x);
            }
            // down
            else{
                right = Math.min(right, x);
            }

            //
            if(right-left==2){
                key = Math.min(key, i+1);
                tf = 1;
            }
            if(right-left<=1){
                key = i+1;
                tf = -1;
                break;
            }
//            if(x==1e18 || x==-1e18){
//                key = i+1;
//                tf =false;
//                break;
//            }
        }





        if(tf==-1){
            System.out.println("Paradox!\n" +key);
        }
        else if(tf==0){
            System.out.println("Hmm...");
        }
        else {
            System.out.println("I got it!\n" +key);
        }


    }
}