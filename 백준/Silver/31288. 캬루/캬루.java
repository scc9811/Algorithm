import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] steps1 = {-7, -4, -1, 2, 5, 8};
    static int[] steps2 = {-2, -5, -8, 1, 4, 7};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        mainLoop:
        while(testCase-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            char[] p = st.nextToken().toCharArray();
            if(n==1){
                sb.append(6).append(' ').append(3).append('\n');
                continue mainLoop;
            }
            int sum = 0;
            for(int i=0; i<n; i++){
                sum += p[i]-'0';
            }

            if(sum%3==1){
                int count = 0;
                for(int i=n-1; i>=0; i--){
                    int base = p[i]-'0';
                    List<Integer> list = new ArrayList<>();
                    for(int j=0; j<6; j++){
                        int newNumber = base + steps1[j];
                        if(newNumber > 0 && newNumber <10){
                           list.add(newNumber);
                        }
                    }

                    for(int j : list){
                        for(int k=0; k<i; k++){
                            sb.append(p[k]);
                        }
                        sb.append(j);
                        for(int k=i+1; k<n; k++){
                            sb.append(p[k]);
                        }
                        sb.append(' ').append(3).append('\n');
                        count++;
                        if(count==n){
                            continue mainLoop;
                        }
                    }




                }
            }
            else if(sum%3==2){
                int count = 0;
                for(int i=n-1; i>=0; i--){
                    int base = p[i]-'0';
                    List<Integer> list = new ArrayList<>();
                    for(int j=0; j<6; j++){
                        int newNumber = base + steps2[j];
                        if(newNumber > 0 && newNumber <10){
                            list.add(newNumber);
                        }
                    }

                    for(int j : list){
                        for(int k=0; k<i; k++){
                            sb.append(p[k]);
                        }
                        sb.append(j);
                        for(int k=i+1; k<n; k++){
                            sb.append(p[k]);
                        }
                        sb.append(' ').append(3).append('\n');
                        count++;
                        if(count==n){
                            continue mainLoop;
                        }
                    }
                }
            }






        }
        System.out.println(sb);



















    }
}