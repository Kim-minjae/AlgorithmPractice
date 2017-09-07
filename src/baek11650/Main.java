package baek11650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by pose2 on 2017-09-05.
 */
public class Main {
    public static void main(String args[])throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        Node[] nodes = new Node[n];


        for(int  i = 0; i< n ;i ++){
            st = new StringTokenizer(br.readLine());
            nodes[i] = new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(nodes);

        for(Node a : nodes){
            System.out.println(a.x + " " + a.y);
        }

    }
}
class Node implements Comparable<Node>{
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Node o) {
        if(this.x == o.x){
            return this.y - o.y;
        }

        return this.x - o.x;
    }
}
