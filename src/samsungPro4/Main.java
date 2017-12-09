package samsungPro4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by pose2 on 2017-10-02.
 */
public class Main {

    private static int[][] dp;
    private static int[] parents;
    private static ArrayList<Integer>[] child;

    public static void main(String args[])throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        int root = -1;

        for(int t = 0; t<tc; t++){

            int n = Integer.parseInt(br.readLine());

            parents = new int[n];
            dp = new int[n][4];
            child = new ArrayList[n];

            for(int i = 0; i<n; i++){
                child[i] = new ArrayList<>();
            }

            for(int i = 0; i<n; i++){
                Arrays.fill(dp[i], Integer.MAX_VALUE);
            }

            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i = 0; i<n; i++){

                int tmp = Integer.parseInt(st.nextToken());
                parents[i] = tmp;

                if(tmp ==  -1) {
                    root = i;
                    continue;
                }

                child[tmp].add(i);
            }

            for(int i = 0; i<n; i++){
                if(child[i].size() == 0){
                    dp[i][1] =1;
                    dp[i][2] =2;
                    dp[i][3] =3;
                }
            }

            System.out.println(Math.min(dfs(root,1),Math.min(dfs(root,2),dfs(root,3))));

        }

    }
    //이게 StackOverFlow나면 indegree(위상정렬)로 좀 추가해주면 된다.
    public static int dfs(int index, int value){

        if(dp[index][value] != Integer.MAX_VALUE) return dp[index][value];

        int value1 = value+1; if(value1>3) value1-=3;
        int value2 = value+2; if(value2>3) value2-=3;

        int result = value;

        for(int k : child[index]) {
            result += Math.min(dfs(k, value1), dfs(k, value2));
        }
        return result;
    }

}
