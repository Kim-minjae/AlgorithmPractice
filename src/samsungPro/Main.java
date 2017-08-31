package samsungPro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by pose2 on 2017-08-26.
 */
public class Main {

    public static void main(String args[])throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int dp[][] = new int[7][279936];
        int tc = Integer.parseInt(st.nextToken());

        for(int t = 0; t<tc; t++){

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] map = new int[N+7];
            PriorityQueue<Node> pq = new PriorityQueue<>();
            int[] cardArray = new int[K+1];

            for(int i = 1; i<K+1; i++){
                cardArray[i] = M;
            }

            st = new StringTokenizer(br.readLine());

            for(int i = 1 ; i< N+1; i++){
                if(i<7){
                    map[N+i] = map[i] = Integer.parseInt(st.nextToken());
                }
                else {
                    map[i] = Integer.parseInt(st.nextToken());
                }
            }
            for(int i = 0; i<7; i++) {
                Arrays.fill(dp[i], Integer.MAX_VALUE);
            }

            pq.offer(new Node(0,1,0,cardArray));

            while (!pq.isEmpty()){

                Node tmpNode = pq.poll();

                if(tmpNode.index>N) {
                    System.out.println(tmpNode.cost);
                    break;
                }

                for(int i = 1; i<K+1; i++){
                    if(tmpNode.cardArray[i] > 0 && i != tmpNode.presentCard){

                        int tmpPoint = tmpNode.bitmask+(int)Math.pow(6,i);

                        if(dp[i][tmpPoint]>tmpNode.cost+map[tmpNode.index+i]) {

                            dp[i][tmpPoint] = tmpNode.cost+map[tmpNode.index+i];
                            int[] tmpArray = tmpNode.cardArray.clone();
                            tmpArray[i]--;
                            Node a = new Node(i, tmpNode.index + i, tmpNode.cost + map[tmpNode.index + i], tmpArray.clone());
                            a.setBitmask(K);
                            pq.offer(a);
                            tmpArray[i]++;
                        }
                    }
                }

            }


        }

    }
}
class Node implements Comparable<Node>{

    int presentCard;
    int index;
    int cost;
    int[] cardArray;
    int bitmask;

    public Node(int presentCard,int index, int cost, int[] cardArray) {
        this.presentCard = presentCard;
        this.index = index;
        this.cost = cost;
        this.cardArray = cardArray;
    }
    public void setBitmask(int K){
        int tmp = 0;
        for(int i = 1; i<K+1; i++){
            bitmask += cardArray[i]*(int)Math.pow(6,i);
        }
    }
    @Override
    public int compareTo(Node o) {
        return cost - o.cost;
    }
}
