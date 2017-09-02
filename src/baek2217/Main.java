package baek2217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * Created by pose2 on 2017-09-02.
 */
public class Main {
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[] dp = new long[n+1];
        int[] map = new int[n+1];
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        for(int i = 0 ; i<n; i++){
            pq.offer(Integer.parseInt(br.readLine()));
        }

        for(int i = 0; i<n; i++){
            map[i] = pq.poll();
        }

        int max = 0;

        for(int i = 0; i<n; i++){

            max = Math.max(max,map[i]*(n-i));

        }

        System.out.println(max);

    }
}
