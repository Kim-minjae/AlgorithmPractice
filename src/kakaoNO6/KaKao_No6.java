package kakaoNO6;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by pose2 on 2017-09-15.
 */
public class KaKao_No6 {
    public static void main(String args[]){
        Solution a = new Solution();

        int[] tmp = {14, 6, 5, 11, 3, 9, 2, 10};

        System.out.println(a.solution(tmp));
    }
}
class Solution {

    static class Man implements Comparable<Man>{
        int index;
        boolean[] visit;
        int sum;

        public Man(int index, boolean[] visit, int sum) {

            this.index = index;
            this.visit = visit;
            this.sum = sum;

        }

        public void visitCheck(){
            //마지막 length -1 을 뜯으면 바로 끝내도록 처리해서 예외처리하지않는다.
            if(index==0){
                visit[visit.length-1] = true;
                visit[index] = true;
                visit[index+1] = true;
            }else {
                visit[index] = true;
                visit[index+1] = true;
                visit[index-1] = true;
            }
        }

        @Override
        public int compareTo(Man o) {
            return o.sum - sum;
        }
    }

    public int solution(int sticker[]) {

        if(sticker.length == 1)return sticker[0];

        int dp[][] = new int[2][sticker.length];
        Queue<Man> queue = new LinkedList<>();

        Man man0 = new Man(0,new boolean[sticker.length],sticker[0]);
        Man man1 = new Man(1,new boolean[sticker.length],sticker[1]);

        queue.offer(man0);
        queue.offer(man1);

        int Max = 0;

        while (!queue.isEmpty()){

            Man tmpMan = queue.poll();
            if(tmpMan.visit[sticker.length-1]){
                if(tmpMan.sum<dp[1][tmpMan.index]){
                    continue;
                }else {
                    dp[1][tmpMan.index] = tmpMan.sum;
                }
            }else {
                if(tmpMan.sum<dp[0][tmpMan.index]){
                    continue;
                }else {
                    dp[0][tmpMan.index] = tmpMan.sum;
                }
            }

            Max = Math.max(Max, tmpMan.sum);

            if(tmpMan.index == sticker.length-1) continue;
            tmpMan.visitCheck();

            if(tmpMan.index+2 <sticker.length && !tmpMan.visit[tmpMan.index+2]){
                queue.offer(new Man(tmpMan.index+2,tmpMan.visit.clone(),tmpMan.sum+sticker[tmpMan.index+2]));
            }
            if(tmpMan.index+3<sticker.length && !tmpMan.visit[tmpMan.index+3]){
                queue.offer(new Man(tmpMan.index+3,tmpMan.visit.clone(),tmpMan.sum+sticker[tmpMan.index+3]));
            }
        }
        return Max;
    }
}
