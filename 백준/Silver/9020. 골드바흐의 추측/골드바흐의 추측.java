import java.io.*;

public class Main {
    static boolean[] array = new boolean[10001];
    public static void main(String[] args)throws IOException {
        array[2] = true;
        for (int i=3; i<=10000; i++){
            boolean tf = true;
            for (int j=2; j*j<=i; j++){
                if(i%j==0){
                    tf = false;
                    break;
                }
            }
            if (tf) array[i] = true;
            else array[i] = false;
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());


        while (testCase-->0){
            StringBuilder sb = new StringBuilder();
            int n = Integer.parseInt(br.readLine());
            for (int i=n/2; i<n; i++){
                if (array[i] && array[n-i]){
                    sb.append(n-i).append(" ").append(i).append("\n");
                    bw.write(sb.toString());
                    break;
                }
            }


        }
        bw.close();











    }

}
