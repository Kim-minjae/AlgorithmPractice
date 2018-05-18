package wooABros;

import java.io.IOException;
import java.util.Arrays;

public class Solution03 {
    public static void main(String args[]) throws IOException {

        int[] A = {10,19,15};


        Solution03 a = new Solution03();
        System.out.println(a.solution(A,2,2));

    }
    public int solution (int[] A, int K, int L) {

        int result = 0;

        if(A.length<K || A.length<L) return -1;

        for(int i =0; i< A.length-K; i++){

            int tmpSum = 0;

            for(int j = 0; j<K; j++){
                tmpSum += A[i+j];
            }

            int[] arrayFront = Arrays.copyOfRange(A,0,i);
            int[] arrayBack = Arrays.copyOfRange(A,i+L+1, A.length);

            result = Math.max(result,
                        Math.max(tmpSum+maxNumAndIndex(arrayFront,L) ,
                                tmpSum+maxNumAndIndex(arrayBack,L)));

        }

        if(result <= 0) result = -1;

        return result;
    }

    public static int maxNumAndIndex(int[] array, int range) {

        if(array.length<range) {

           return -300000;
        }

        int maxsum = 0;

        for(int  i = 0; i<array.length-range+1; i++) {

            int tmpSum = 0;
            for(int j = 0; j<range; j++){
                tmpSum += array[i+j];
            }

            maxsum = Math.max(maxsum,tmpSum);
        }

        return maxsum;

    }
}
