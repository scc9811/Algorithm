import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] array = new String[N];
        String[] array2 = new String[N];
        int count=0;
        for (int i=0; i<N; i++)
            array[i] = br.readLine();
        Arrays.sort(array);
        for (int i=0; i<M; i++){
            String s = br.readLine();
            if (Arrays.binarySearch(array,s)>=0){
                array2[count] = s;
                count++;
            }
        }
        Arrays.sort(array2,0,count);

        StringBuilder sb = new StringBuilder();
        sb.append(count+"\n");
        for (int i=0; i<count-1; i++){
            sb.append(array2[i]+"\n");
        }
        if (count>0) sb.append(array2[count-1]);
        bw.write(sb.toString());
        bw.close();

    }
}
