import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int index = 1;
        arr[0] = Integer.parseInt(st.nextToken());
        for(int i=1; i<n; i++){
            int key = Integer.parseInt(st.nextToken());
            if(key > arr[index-1]) {
                arr[index++] = key;
            }
            else if(key < arr[index-1]){
                for(int j=0; j<index; j++){
                    if(key <= arr[j]) {
                        arr[j] = key;
                        break;
                    }
                }
            }
//            System.out.println(Arrays.toString(arr));
        }
//        System.out.println(Arrays.toString(arr));

        System.out.println(index);





    }
}

