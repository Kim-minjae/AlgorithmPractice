package baek11279;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by pose2 on 2017-09-12.
 */
public class Main {
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Mycomp());

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i<n; i++){
            int command = Integer.parseInt(br.readLine());

            if(command == 0){

                if(pq.isEmpty()){
                    System.out.println(0);
                }else {
                    int tmp = pq.poll();
                    System.out.println(tmp);
                }
            }else {
                pq.offer(command);
            }


        }

    }

}
class Mycomp implements Comparator<Integer>{
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2.compareTo(o1);
    }
}