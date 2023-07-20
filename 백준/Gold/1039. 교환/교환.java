import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String n = st.nextToken();
        int operCount = Integer.parseInt(st.nextToken());

        Queue<String> queue = new LinkedList<>();
        queue.add(n);

        for (int i = 0; i < operCount; i++) {
            Queue<String> tmpQ = new LinkedList<>();
            while (!queue.isEmpty()) {
                String curS = queue.poll();
                for (int j = 0; j < n.length(); j++) {
                    for (int k = j + 1; k < n.length(); k++) {
                        char[] s = curS.toCharArray();
                        s[j] = curS.charAt(k);
                        s[k] = curS.charAt(j);
                        if (s[0] == '0') continue;
                        StringBuilder sb = new StringBuilder();
                        for (int l = 0; l < n.length(); l++) {
                            sb.append(s[l]);
                        }
                        if(!tmpQ.contains(sb.toString())) tmpQ.add(sb.toString());
                    }
                }
            }
            queue = tmpQ;
        }

        int max = -1;
        while(!queue.isEmpty()){
            max = Math.max(max, Integer.parseInt(queue.poll()));
        }
        System.out.println(max);


       
    }
}