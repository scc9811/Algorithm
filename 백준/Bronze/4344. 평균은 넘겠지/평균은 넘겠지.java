import java.io.*;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());
        while(testCase-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int students = Integer.parseInt(st.nextToken());
            int[] score = new int[students];
            float average = 0;
            for (int i=0; i<students; i++){
                score[i] = Integer.parseInt(st.nextToken());
                average += score[i];
            }
            average /= students;

            float count=0;
            for (int i=0; i<students; i++){
                if(score[i]>average) count++;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("%.3f",count/students*100)).append("%\n");
            bw.write(sb.toString());

        }
        bw.close();

    }
}
