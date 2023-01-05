import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<String> nickNameS = new HashSet<>();
        Map<String, Integer> nameCount = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            String s = br.readLine();
            String nickName = null;
            for(int j=0; j<s.length(); j++){
                String subS = s.substring(0,j+1);
                if(nickName==null && !nickNameS.contains(subS)){
                    nickName = subS;
                }
                nickNameS.add(subS);
            }

            if(nickName==null){
                int nCount = nameCount.getOrDefault(s, 0);
                sb.append(s);
                if(nCount!=0) sb.append(nCount+1);
            }
            else{
                sb.append(nickName);
            }
            sb.append('\n');
            nameCount.put(s, nameCount.getOrDefault(s, 0)+1);
        }





        System.out.println(sb);



    }
}
