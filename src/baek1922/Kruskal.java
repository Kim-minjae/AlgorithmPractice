package baek1922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by pose2 on 2017-09-14.
 */
public class Kruskal {

    static Integer[] parents;

    public static void main(String args[])throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        parents = new Integer[n+1];
        for(Integer i = 0; i<n+1; i++){
            parents[i] = i;
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        for(int i = 0; i<m; i++){

            StringTokenizer st = new StringTokenizer(br.readLine());
            int tmpStart = Integer.parseInt(st.nextToken());
            int tmpEnd = Integer.parseInt(st.nextToken());
            int tmpWeight = Integer.parseInt(st.nextToken());

            pq.offer(new Edge(tmpStart,tmpEnd,tmpWeight));

        }

        int sum =0;

        while (!pq.isEmpty()){
            Edge tmpEdge = pq.poll();

            if(union(tmpEdge.start,tmpEdge.end)){
                sum+=tmpEdge.weight;
            }
        }
        System.out.println(sum);
    }

    public static boolean union(int v1, int v2){
        if(parents[v1].equals(parents[v2])){
            return false;
        }
        parents[v2] = parents[v1];
        return true;
    }

    static class Edge implements Comparable<Edge>{

        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return weight- o.weight;
        }
    }
}
