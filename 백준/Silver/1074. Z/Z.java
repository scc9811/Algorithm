import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    static int count = 0;
    static int size1, r, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        size1 = (int) Math.pow(2, Integer.parseInt(st.nextToken()));
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());



        z(size1/2, 0, 0);



    }

    public static void z(int size, int startI, int startJ) {

        if (size == 1) {
            if(startI==r){
                if(startJ==c){
                    System.out.println(count);
                }
                else System.out.println(count+1);
            }
            else{
                if(startJ==c) System.out.println(count+2);
                else System.out.println(count+3);
            }
            return;
        }

        if(startI+size>r){
            if(startJ+size>c) {
                z(size/2, startI, startJ);
            }
            else {
                count += Math.pow(size,2);
                z(size/2, startI, startJ+size);
            }


        }
        else{
            if(startJ+size>c){
                count += 2*Math.pow(size,2);
                z(size/2, startI+size, startJ);
            }
            else {
                count += 3*Math.pow(size,2);
                z(size/2, startI+size, startJ+size);
            }
        }

//        z(size / 2, startI, startJ);
//        z(size / 2, startI, startJ + size);
//        z(size / 2, startI + size, startJ);
//        z(size / 2, startI + size, startJ + size);


    }
}