import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int vertex = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        int[] array = new int[vertex+1];

        while (edge-->0){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            if (array[start]==0 && array[end]==0){
                array[start] = start;
                array[end] = start;
            }
            else if (array[start]==0){
                array[start] = array[end];
            }
            else if (array[end]==0){
                array[end] = array[start];
            }

            else if (array[start]!=array[end]){
                int tmp = array[end];
                for (int i=1; i<=vertex; i++) {
                    if (array[i] == tmp)
                        array[i] = array[start];
                }
            }

        }

        for (int i=1; i<=vertex; i++){
            if (array[i]!=0 && array[i]!=-1){
                array[array[i]] = -1;
            }
        }
        int count = 0;
        for (int i=1; i<=vertex; i++){
            if (array[i]==-1 || array[i]==0) count++;
        }


        System.out.println(count);


    }
}
