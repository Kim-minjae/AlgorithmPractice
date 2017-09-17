package baek1715;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * Created by pose2 on 2017-09-12.
 */
public class Main {
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue();

        for(int i = 0; i<n; i++){
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int sum = 0;

        while (pq.size()>1)
        {
            int tmp1 = pq.poll();
            int tmp2 = pq.poll();

            sum += tmp1+tmp2;

            pq.offer(tmp1 + tmp2);

        }
        System.out.println(sum);
    }
}
