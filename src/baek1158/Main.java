package baek1158;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by pose2 on 2017-09-08.
 */
public class Main {
    public static void main(String args[])throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i<N; i++){
            queue.offer(i+1);
        }

        StringBuffer stringBuffer = new StringBuffer("");

        System.out.print("<");
        while (!queue.isEmpty()){

            for(int i = 0; i<M-1; i++){
                queue.offer(queue.poll());
            }
            stringBuffer.append(queue.poll() );
            stringBuffer.append(", ");
        }

        stringBuffer.deleteCharAt(stringBuffer.length()-2);
        stringBuffer.deleteCharAt(stringBuffer.length()-1);

        System.out.print(stringBuffer);
        System.out.print(">");

    }
}

