package baek1764;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by pose2 on 2017-09-08.
 */
public class Main {
    public static void main(String args[])throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashSet<String> set1 = new HashSet<>();


        PriorityQueue<String> result = new PriorityQueue<>();


        for(int i = 0;i <n; i++){
            set1.add(br.readLine());
        }
        for(int i = 0;i <m; i++){
            String tmp = br.readLine();
            if(set1.contains(tmp)){
                result.offer(tmp);
            }
        }

        System.out.println(result.size());
        while (!result.isEmpty()){
            System.out.println(result.poll());
        }

    }
}
