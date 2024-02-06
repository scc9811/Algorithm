class Solution {
     public int solution(int coin, int[] cards) {

        int n = cards.length;
        int round = 1;
        boolean[] visited = new boolean[n+1];
        int pointer = n/3;

        mainLoop:
        while(pointer < n){
            boolean isValidRound = false;
            pointer += 2;
            // 초기에 갖고있던 카드 먼저 판단
            for(int i=0; i<n/3; i++){
                for(int j=i+1; j<n/3; j++){
                    if(cards[i] + cards[j] == n+1 && !visited[i] && !visited[j]){
                        visited[i] = true;
                        visited[j] = true;
                        round++;
                        continue mainLoop;
                    }
                }
            }


            subLoop:
            for(int i=0; i<pointer; i++){
                for(int j=i+1; j<pointer; j++){
                    if(cards[i] + cards[j] == n+1 && !visited[i] && !visited[j]){
                        visited[i] = true;
                        visited[j] = true;
                        isValidRound = true;

                        // i 카드는 초기카드, j번 카드는 이후에 뽑은 카드
                        if(i < n/3 && j >= n/3){
                            coin--;
                        }
                        // 두 카드 모두 이후에 뽑은 카드
                        else if(i >= n/3){
                            coin -= 2;
                        }
                        else{
                            System.out.println("error");
                        }
                        break subLoop;
                    }
                }
            }

            if(!isValidRound || coin < 0) break;
            round++;
        }


        return round;
    }
}