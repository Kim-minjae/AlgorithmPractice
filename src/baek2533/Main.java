package baek2533;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by pose2 on 2017-08-20.
 */
public class Main {
    public static void main(String args[]) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        boolean[] teamA = new boolean[1000001];
        boolean[] teamB = new boolean[1000001];

        int dpA = 0;
        int dpB = 0;

        teamA[1] = true;
        dpA++;

        for(int i = 0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());


            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(teamA[a]){

                teamB[b] = true;
                dpB++;

            }else if(teamB[a]){

                teamA[b] = true;
                dpA++;

            }
        }

        System.out.println(Math.min(dpA,dpB));

    }
}
