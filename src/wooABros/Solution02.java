package wooABros;

import java.io.IOException;


public class Solution02 {
    public static void main(String args[]) throws IOException {
        Solution02 a= new Solution02();
        System.out.println(a.solution(2,4,2,4));

    }
    public int solution(int A, int B, int C, int D) {

        int[] nums = {A,B,C,D};
        int[] nums2 = new int[4];
        boolean[] visit = new boolean[4];

        int result  = (int) dfs(nums,nums2,visit,0);
        return result;
    }
    public double dfs(int[] nums1, int[] nums2, boolean[] visit, int depth) {

        double result = 0;

        if(depth == 4) {
            return Math.pow(nums2[0]-nums2[2],2) + Math.pow(nums2[1]-nums2[3],2);
        }




        for(int i = 0; i<4; i++){
            int[] tmpNum2 = nums2.clone();
            boolean[] tmpVisit = visit.clone();
            if(!visit[i]){
                tmpNum2[depth] = nums1[i];
                tmpVisit[i] = true;
                result = Math.max(result,dfs(nums1, tmpNum2, tmpVisit, depth+1));
            }

        }

        return result;
    }
}
