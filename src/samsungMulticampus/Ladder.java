package samsungMulticampus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by pose2 on 2017-09-05.
 */
public class Ladder {
    public static void main(String args[])throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc  = Integer.parseInt(br.readLine());

        for(int t = 0 ; t<tc; t++){

            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int indexOfBomb = Integer.parseInt(st.nextToken());

            int[][] map = new int[N+1][N+1];

            int ladderNum = Integer.parseInt(st.nextToken());

            for(int i =0 ;i <ladderNum; i++){

                int x1 = Integer.parseInt(st.nextToken());
                int y1 = Integer.parseInt(st.nextToken());
                int x2 = Integer.parseInt(st.nextToken());
                int y2 = Integer.parseInt(st.nextToken());

                map[x1][y1] = y2;
                map[x2][y2] = y1;

            }

            int[] bomb = new int[2];
            bomb[0] = map.length;
            bomb[1] = indexOfBomb;


            for(int i = map.length; i>0; i--){

                bomb[0]--;

                if(map[bomb[0]][bomb[1]] != 0){
                    bomb[1] = map[bomb[0]][bomb[1]];
                }

            }

            System.out.println(bomb[1]);



        }

    }
}
