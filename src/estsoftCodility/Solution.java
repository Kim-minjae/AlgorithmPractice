package estsoftCodility;

import java.io.IOException;

/**
 * Created by pose2 on 2018-01-10.
 */
public class Solution {
    public int solution(int N) {
        // write your code in Java SE 8

        int tmpN = N ;

        int max = 0;
        int tmpMax = 0;

        while (tmpN>0){

            if((tmpN & 1) == 1){

                max = Math.max(max, tmpMax);
                tmpMax = 0;

            }else {
                tmpMax++;
            }

            tmpN =  tmpN>>1;

        }


        return max;
    }
    public static void main(String args[]) throws IOException {

        Solution a = new Solution();
        System.out.println(a.solution(16));


    }
}
