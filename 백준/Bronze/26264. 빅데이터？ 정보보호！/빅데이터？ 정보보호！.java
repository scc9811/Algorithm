import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String s = br.readLine();
        int sCount = 0;
        int bCount = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='s') sCount++;
            else if(s.charAt(i)=='b') bCount++;
        }
        if(sCount==bCount) System.out.println("bigdata? security!");
        else if(sCount>bCount) System.out.println("security!");
        else System.out.println("bigdata?");


    }
}