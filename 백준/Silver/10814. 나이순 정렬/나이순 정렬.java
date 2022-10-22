import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String[][] array;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        array = new String[201][n];
        int[] indexArray = new int[201];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            array[age][indexArray[age]]=st.nextToken();
            indexArray[age]++;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=200; i++){
            for(int j=0; j<indexArray[i]; j++){
                sb.append(i).append(' ').append(array[i][j]).append('\n');
            }
        }
        System.out.println(sb);












    }
    // array[index][0] = age , array[index][1] = name
//    public static void insert(int index, String age, String name){
//        count++;
//        for(int i=count-2; i>=index; i--){
//            array[i+1][0] = array[i][0];
//            array[i+1][1] = array[i][1];
//        }
//        array[index][0] = age;
//        array[index][1] = name;
//    }
}