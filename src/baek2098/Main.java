package baek2098;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by pose2 on 2017-08-26.
 */
public class Main {

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[][] map = new int[16][16];
        int[] dp = new int[(int)Math.pow(2,17)+1];

        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Node tmpNode = new Node(0,0,0);
        pq.offer(tmpNode);

        while (!pq.isEmpty()){

            tmpNode = pq.poll();

            if(tmpNode.getBitmask() == ((int)(Math.pow(2,N))-1)) break;

//            pq.offer(tmpNode);

            do  {

//                tmpNode = pq.poll();

                for(int i = 1; i<N; i++){
                    if(map[tmpNode.getIndex()][i] != 0){
                        if((tmpNode.getBitmask() & (1<<i)) == 0){
                            if(dp[tmpNode.getBitmask() + (int)Math.pow(2,i)] == 0 || dp[tmpNode.getBitmask()+(int)Math.pow(2,i)] > map[tmpNode.getIndex()][i] + tmpNode.getCost()){

                                dp[tmpNode.getBitmask() + (int)Math.pow(2,i)] = map[tmpNode.getIndex()][i] + tmpNode.getCost();
                                Node tmpNode2 = new Node(i,map[tmpNode.getIndex()][i] + tmpNode.getCost(),tmpNode.getBitmask()+(int)Math.pow(2,i));
                                pq.offer(tmpNode2);

                            }
                        }
                    }
                }
            }while(!pq.isEmpty() && (tmpNode.getBitmask() < (int)(Math.pow(2,N)-2)));
//                dp[(int)Math.pow(2,N)-1] = tmpNode.getCost()+map[tmpNode.getIndex()][0];

                Node tmpNode3 = new Node(0,map[tmpNode.getIndex()][0] + tmpNode.getCost(),tmpNode.getBitmask()+1);
                pq.offer(tmpNode3);


        }
        System.out.println(tmpNode.getCost());
    }
}

class Node implements Comparable<Node>{

    int index;
    int cost;
    int bitmask;

    public Node(int index, int cost, int bitmask) {
        this.index = index;
        this.cost = cost;
        this.bitmask = bitmask;
    }

    public int getIndex() {
        return index;
    }

    public int getCost() {
        return cost;
    }

    public int getBitmask() {
        return bitmask;
    }

    public void setBitmask(int K){
        int tmp = 0;
        this.bitmask += Math.pow(2,this.index);
    }
    @Override
    public int compareTo(Node o) {
        return cost - o.cost;
    }
}