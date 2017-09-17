package baek11725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by pose2 on 2017-09-12.
 */
public class Main{

    static int[] parents ;
    static int n;
    static ArrayList<ArrayList<Integer>> arr;
    static PriorityQueue<Node> pq;
    static Queue<Integer> q;
    static boolean[] visit;

    public static void main(String args[]) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        visit = new boolean[100001];
        n = Integer.parseInt(br.readLine());

        arr = new ArrayList<ArrayList<Integer>>();

        for(int i = 0;i<100001; i++) {
            arr.add(new ArrayList<Integer>());
        }

        for(int i = 0 ; i<n-1; i++){

            StringTokenizer st = new StringTokenizer(br.readLine());

            int tmpX = Integer.parseInt(st.nextToken());
            int tmpY = Integer.parseInt(st.nextToken());

            if(arr.get(tmpX) == null){
                arr.add(tmpX,new ArrayList<Integer>());
                arr.get(tmpX).add(tmpY);
            }else {
                arr.get(tmpX).add(tmpY);
            }
            if(arr.get(tmpY) == null){
                arr.add(tmpY,new ArrayList<Integer>());
                arr.get(tmpY).add(tmpX);
            }else {
                arr.get(tmpY).add(tmpX);
            }

        }


        q = new LinkedList<>();
        pq = new PriorityQueue<>();

        q.offer(1);

        while (!q.isEmpty()){
            int tmp = q.poll();
            find(tmp);
        }

        pq.poll();

        while (!pq.isEmpty()){
            Node tmp2 = pq.poll();
            System.out.println(tmp2.parent);
        }
    }
    public static void find(int tmpParent){

        for(int i= 0; i<arr.get(tmpParent).size() ; i++){

            int tmpAdol = arr.get(tmpParent).get(i);
            if(!visit[tmpAdol])
            {
                pq.offer(new Node(tmpAdol,tmpParent));
                q.offer(tmpAdol);
                visit[tmpAdol] = true;
            }
        }
    }
}


class Node implements Comparable<Node>{
    int index;
    int parent;

    public Node(int index, int parent) {
        this.index = index;
        this.parent = parent;
    }

    @Override
    public int compareTo(Node o) {
        return index-o.index;
    }
}