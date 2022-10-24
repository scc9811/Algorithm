import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args)throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[2000001];
        int startIndex=0;
        int lastIndex=0;
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while(testCase-->0){
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if(s.equals("push")){
                array[lastIndex++]=Integer.parseInt(st.nextToken());
            }
            else if(s.equals("pop")){
                if(lastIndex-startIndex==0) bw.write("-1");
                else{
                    bw.write(String.valueOf(array[startIndex++]));
                }
                bw.write('\n');
            }
            else if(s.equals("size")) {
                bw.write(String.valueOf(lastIndex-startIndex));
                bw.write('\n');
            }
            else if(s.equals("empty")) {
                if(lastIndex-startIndex==0) bw.write("1");
                else bw.write("0");
                bw.write('\n');
            }
            else if(s.equals("front")){
                if(lastIndex-startIndex==0) bw.write("-1");
                else bw.write(String.valueOf(array[startIndex]));
                bw.write('\n');
            }
            else if(s.equals("back")){
                if(lastIndex-startIndex==0) bw.write("-1");
                else bw.write(String.valueOf(array[lastIndex-1]));
                bw.write('\n');
            }






        }
        bw.close();




    }

}
