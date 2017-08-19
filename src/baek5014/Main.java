package baek5014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by pose2 on 2017-08-19.
 */
public class Main {
    public static void main(String args[]) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        boolean[] building = new boolean[F+1]; //F층짜리 건물 체크배열
        building[0] = true;//0층은 없고 1층부터임.

        //카운트와 현재 층수를 저장하고있는 Node를 소팅해서 저장하는 pq
        PriorityQueue<Node> q = new PriorityQueue<>();

        Node kangho = new Node(0,S);
        q.offer(kangho);

        while (!q.isEmpty()){

            Node tmpNode = q.poll();

            if(tmpNode.presentFloor == G){
                System.out.println(tmpNode.getButtonCount());
                return;
            }else if(G - tmpNode.presentFloor > 0){
                if(U != 0) {
                    if ((G - tmpNode.presentFloor) % U == 0) {
                        int tmp = (G - tmpNode.presentFloor) / U + tmpNode.getButtonCount();
                        System.out.println(tmp);
                        return;
                    }
                }
            }else{
                if(D != 0) {
                    if ((tmpNode.presentFloor - G) % D == 0) {
                        int tmp2 = (tmpNode.presentFloor - G) / D + tmpNode.getButtonCount();
                        System.out.println(tmp2);
                        return;
                    }
                }
            }

            building[tmpNode.presentFloor] = true;

            if(tmpNode.presentFloor+U <= F && !building[tmpNode.presentFloor+U]){
                q.offer(new Node(tmpNode.getButtonCount()+1,tmpNode.getPresentFloor()+U));
            }
            if(tmpNode.presentFloor-D >=1 && !building[tmpNode.presentFloor-D]){
                q.offer(new Node(tmpNode.getButtonCount()+1,tmpNode.getPresentFloor()-D));
            }

        }
        System.out.println("use the stairs");

    }
}
class Node implements Comparable<Node>{
    int buttonCount;
    int presentFloor;

    public Node(int buttonCount, int presentFloor) {
        this.buttonCount = buttonCount;
        this.presentFloor = presentFloor;
    }

    public int getButtonCount() {
        return buttonCount;
    }

    public int getPresentFloor() {
        return presentFloor;
    }

    @Override
    public int compareTo(Node o) {
        return this.buttonCount - o.buttonCount;
    }
}
