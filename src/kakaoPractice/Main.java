package kakaoPractice;

import java.io.IOException;

/**
 * Created by pose2 on 2017-09-23.
 */
public class Main {
    public static void main(String args[])throws IOException{
        int[] sticker = {3,9,16};


        System.out.println(Solution.solution(sticker));

    }
    static class Solution{
        public static int solution(int[] stickers){

            int N = stickers.length;

            if(N <= 3){
                int max = 0;
                for(int i = 0; i<N; i++){
                    max = Math.max(max,stickers[i]);
                }
                return max;
            }

            int[] sticker = new int[N+3];
            for(int i = 0 ; i <N;i++){
                sticker[i] = stickers[i];
            }
            int answer = 0;

            int[] a = new int[N+4];
            a[0] = sticker[0];
            int[] b = new int[N+4];
            b[1] = sticker[1];
            for(int i = 0; i < N; i++){
                if(a[i+2] < a[i] + sticker[i+2]){
                    a[i+2] =  a[i] + sticker[i+2];
                }
                if(a[i+3] < a[i] + sticker[i+3]){
                    a[i+3] =  a[i] + sticker[i+3];
                }
            }
            for(int i = 1; i < N; i++){
                if(b[i+2] < b[i] + sticker[i+2]){
                    b[i+2] =  b[i] + sticker[i+2];
                }
                if(b[i+3] < b[i] + sticker[i+3]){
                    b[i+3] =  b[i] + sticker[i+3];
                }
            }

            int answer1 = Math.max(a[N-2],b[N-1]);
            int answer2 = Math.max(a[N-3],b[N-2]);

            answer = Math.max(answer1,answer2);

            return answer;
        }
    }
}
