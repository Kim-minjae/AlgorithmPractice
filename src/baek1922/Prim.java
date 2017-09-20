package baek1922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by pose2 on 2017-09-14.
 */
public class Prim {

    static  int[] parents;

    public static void main(String args[])throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        parents = new int[n+1];
        for(int i = 0; i<n+1; i++){
            parents[i] = i;
        }

        PriorityQueue<Edge2> pq = new PriorityQueue<>();

        for(int i = 0; i<m; i++){

            StringTokenizer st = new StringTokenizer(br.readLine());
            int tmpStart = Integer.parseInt(st.nextToken());
            int tmpEnd = Integer.parseInt(st.nextToken());
            int tmpWeight = Integer.parseInt(st.nextToken());

            pq.offer(new Edge2(tmpStart,tmpEnd,tmpWeight));

        }

        int sum =0;

        while (!pq.isEmpty()){
            Edge2 tmpEdge = pq.poll();

            if(find(tmpEdge.start,tmpEdge.end)){
                sum+=tmpEdge.weight;
                union(tmpEdge.start,tmpEdge.end);
            }
        }
        System.out.println(sum);
    }

    public static boolean find(int v1, int v2){
        if(parents[v1] == parents[v2]){
            return false;
        }
        return true;
    }

    public static boolean union(int v1, int v2){

        if(parents[v1] == parents[v2]){
            return false;
        }


        int v3 =  parents[v1];
        int v4 =  parents[v2];

        parents[v1] = parents[v2];

        if(v1 == v3 && v2 == v4) {
            return true;
        }
        union(v3, v4);
        return true;
    }

    static class Edge2 implements Comparable<Edge2>{

        int start;
        int end;
        int weight;

        public Edge2(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge2 o) {
            return weight- o.weight;
        }
    }
}