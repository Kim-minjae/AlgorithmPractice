package estsoftCodility2;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by pose2 on 2018-01-10.
 */
public class Solution {

    public static void main(String args[])throws IOException{
        Solution a = new Solution();

        int[] A = {7,1,11,8,4,10};


        System.out.println(a.solution(A,8));

    }

    public int solution(int[] A, int M){

        Queue<Integer> mainQ = new LinkedList<>();
        Queue<Integer> mainQ2 = new LinkedList<>();

        for(int i = 0; i< A.length; i++){
            mainQ.offer(A[i]);
        }

        int max = 1;

        while (mainQ.size()>1){

            int start = mainQ.poll();

            Queue<Integer> tmpQ = new LinkedList<>();


            while (!mainQ.isEmpty()){

                int tmp = mainQ.poll();
                if(((Math.abs(start - tmp))%M) == 0){
                    tmpQ.offer(tmp);
                }else {
                    mainQ2.offer(tmp);
                }

            }

            max = Math.max(max, tmpQ.size()+1);

            while(!mainQ2.isEmpty()){
                mainQ.offer(mainQ2.poll());
            }

        }


        return max;
    }

}
