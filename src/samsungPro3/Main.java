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

            int[][] dpMap = new int[N+1][M+1];
            int[][] dpMap2 = new int[N+1][M+1];

            for(int i = 1; i< N+1; i++){
                String tmp = br.readLine();
                for(int j = 1; j<M+1; j++){
                    dpMap[i][j] = tmp.charAt(j-1) - '0';
                }
            }

            for(int i = 1; i< N+1; i++){
                for(int j =1; j<M+1; j++){
                    if(dpMap[i][j] != 0){

                        dpMap[i][j] = 1 + Math.min(dpMap[i-1][j-1],Math.min(dpMap[i-1][j],dpMap[i][j-1]));

                    }
                }
            }

            for(int i =1 ; i<N+1; i++){
                for(int j = 1; j<M+1; j++){



                }
            }

            /*for(int i = 0; i<dpMap.length; i++){
                System.out.println();
                for(int j = 0; j<dpMap[0].length; j++){
                    System.out.print(dpMap[i][j]);
                }
            }*/

        }

    }
}
