package samsungPro3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by pose2 on 2017-09-24.
 */
public class Main {
    public static void main(String args[]) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for(int t = 0; t<tc; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][][] dpMap = new int[N+1][M+1][3];

            for(int i = 1; i< N+1; i++){
                String tmp = br.readLine();
                for(int j = 1; j<M+1; j++){
                    dpMap[i][j][0] = tmp.charAt(j-1) - '0';
                }
            }

            int sum = 0;

            for(int i = 1; i< N+1; i++){
                for(int j =1; j<M+1; j++){
                    if(dpMap[i][j][0] != 0){

                        dpMap[i][j][0] = 1 + Math.min(dpMap[i-1][j-1][0],Math.min(dpMap[i-1][j][0],dpMap[i][j-1][0]));

                        int tmpLeft = 0;
                        if(dpMap[i][j-1][0] >= 1) tmpLeft = 1;
                        dpMap[i][j][1] = dpMap[i][j-1][1]+ tmpLeft;

                        int tmpRight = 0;
                        if(dpMap[i-1][j][0] >= 1) tmpRight = 1;
                        dpMap[i][j][2] = dpMap[i-1][j][2]+tmpRight;

                        sum+= dpMap[i][j][2]+dpMap[i][j][1]+dpMap[i][j][0];

                    }
                }
            }

            System.out.println(sum);
        }

    }
}
