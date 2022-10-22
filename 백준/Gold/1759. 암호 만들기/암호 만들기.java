import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static char[] array;
    static int m,n;
    static StringBuilder sb = new StringBuilder();
    static char[] useArray;
    static char[] vowelArray = {'a','e','i','o','u'};
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        array = new char[n];
        useArray = new char[m];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            array[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(array);
        backTracking(0,0);
        System.out.println(sb);





    }
    public static void backTracking(int depth, int startIndex){
        if(depth==m){
            if(tf()){
                for(int i=0; i<m; i++){
                    sb.append(useArray[i]);
                }
                sb.append('\n');
            }
            return;
        }

        for(int i=startIndex; i<n; i++){
            useArray[depth]=array[i];
            backTracking(depth+1,i+1);
        }



    }
    public static boolean tf(){
        int count_vowel = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<5; j++){
                if(useArray[i]==vowelArray[j]) {
                    count_vowel++;
                    break;
                }
            }
        }
        // 모음 0개인 경우 false 반환
        if(count_vowel==0) return false;
        // 자음 2개 미만인 경우 false 반환
        if(m-count_vowel<2) return false;
        return true;

    }
}
