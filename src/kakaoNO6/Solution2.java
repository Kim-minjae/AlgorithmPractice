package kakaoNO6;

/**
 * Created by pose2 on 2017-09-15.
 */
class Solution2 {

    public static void main(String args[]){
        Solution2 a = new Solution2();

        int[] tmp = {14, 6, 5, 11, 3, 9, 2, 10};

        System.out.println(a.solution(tmp));
    }

    public int solution(int sticker[]) {

        int[] dp1 = new int[sticker.length];
        int[] dp2 = new int[sticker.length];

        dp1[0] = sticker[0];
        dp2[1] = sticker[1];

        for(int i = 0; i+2<=sticker.length-2; i++){
            if(dp1[i+2] < dp1[i] + sticker[i+2]) {
                dp1[i + 2] = dp1[i] + sticker[i+2];
            }
            if(dp1[i+3] <dp1[i] + sticker[i+3]) {
                dp1[i + 3] = dp1[i] + sticker[i+3];
            }
            if(dp2[i+2]<dp2[i] + sticker[i+2]) {
                dp2[i + 2] = dp2[i] + sticker[i+2];
            }
            if(dp2[i+3] <dp2[i] + sticker[i+3]) {
                dp2[i + 3] = dp2[i] + sticker[i+3];
            }
        }

        int max = 0;

        for(int i = 0; i<sticker.length-1; i++){

            max = Math.max(max,Math.max(dp1[i],dp2[i]));

        }
        Math.max(max, dp2[sticker.length-1]);
        return max;
    }
}