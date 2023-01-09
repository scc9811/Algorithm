import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int aSize = Integer.parseInt(st.nextToken());
        int bSize = Integer.parseInt(st.nextToken());

        Set<Integer> set = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<aSize; i++){
            set.add(Integer.parseInt(st.nextToken()));
        }
        int count = aSize+bSize;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<bSize; i++){
            if(set.contains(Integer.parseInt(st.nextToken()))) count -= 2;
        }
        System.out.println(count);



    }


}