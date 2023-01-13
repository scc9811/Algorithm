import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Score[] arr = new Score[n];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new Score(st.nextToken(), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            sb.append(arr[i].name).append('\n');
        }
        System.out.println(sb);





    }
    public static class Score implements Comparable<Score>{
        String name;
        int a, b, c;
        Score(String name, int a, int b, int c){
            this.name = name;
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public int compareTo(Score o) {
            if(this.a==o.a){
                if(this.b==o.b) {
                    if(this.c==o.c) return this.name.compareTo(o.name);
                    else return Integer.compare(o.c, this.c);
                }
                else return Integer.compare(this.b, o.b);
            }
            else return Integer.compare(o.a, this.a);
        }
    }
}