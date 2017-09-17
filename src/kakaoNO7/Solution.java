package kakaoNO7;

import java.util.Arrays;

/**
 * Created by pose2 on 2017-09-15.
 */
class Solution {

    public static void main(String args[]){
        Solution a = new Solution();
        String[] strs = {"app","ap","p","l","e","ple","pp"};
        String t = "apple";
        System.out.println(a.solution(strs,t));
    }

    public int solution(String[] strs, String t) {
        int answer = 0;
        boolean checker = false;

        String t2;
        t2= t+"      ";

       /* String[][] newStrs = new String[6][strs.length];*/

        int maxLength = 0;

        for(String s : strs){
            maxLength = Math.max(maxLength,s.length());
//            newStrs[s.length()][]
        }

        int dp[] = new int[t2.length()];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i = 0; i<t.length(); i++){

             Loop1 : for(int j = 1; j<maxLength+1; j++){
                for(int k = 0; k<strs.length; k++){

                    String tmp = t2.substring(i,i+j);

                    if(tmp.equals(strs[k]) ) {

                        if(dp[i] == Integer.MAX_VALUE) continue Loop1;
                        if(dp[i+j] >= dp[i] + 1){

                            dp[i+j] = dp[i] + 1;

                        }
                        continue Loop1;
                    }
                }
            }
        }
        answer = dp[t.length()];
        if(answer == Integer.MAX_VALUE) return -1;
        return answer;
    }
}