package baek9372;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by pose2 on 2017-08-28.
 */
public class Main {

    static int[][] map;
    static int N;
    static int M;

    public static void main(String args[])throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for(int t = 0; t<tc; t++){

            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            map = new int[N+1][N+1];

            for(int i = 0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                int tmpX = Integer.parseInt(st.nextToken());
                int tmpY = Integer.parseInt(st.nextToken());

                map[tmpX][tmpY] = map[tmpY][tmpX] = 1;
            }

            boolean[] visit = new boolean[N+1];
            visit[0] = true;

            PriorityQueue<Sangeun> pq = new PriorityQueue<>();

            for(int i = 1; i<N+1; i++){

                boolean[] tmpvisit = new boolean[N+1];
                tmpvisit[0] = true;
                tmpvisit[i] = true;

                pq.offer(new Sangeun(i,tmpvisit,0));
            }

            while (!pq.isEmpty()) {

                Sangeun tmpSangeun = pq.poll();
                boolean[] tmpVisit = tmpSangeun.visit.clone();

                if(allvisit(tmpSangeun.visit)) {
                    System.out.println(tmpSangeun.cost);
                    break;
                }

                for(int i = 1; i<N+1; i++){
                    if(tmpSangeun.index == i)continue;

                    if(map[tmpSangeun.index][i] ==1){
                        tmpVisit[i] = true;

                        pq.offer(new Sangeun(i,tmpVisit.clone(),tmpSangeun.cost+1));
                        tmpVisit[i] = false;
                    }

                }

            }



        }

    }


    public static boolean allvisit(boolean[] visit){

        boolean result = true;

        for(int i = 0; i<visit.length; i++){
            result = result && visit[i];
        }

        return result;

    }
}
class Sangeun implements Comparable<Sangeun>{
    int index;
    boolean[] visit;
    int cost;

    public Sangeun(int index, boolean[] visit, int cost) {
        this.index = index;
        this.visit = visit;
        this.cost = cost;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public boolean[] getVisit() {
        return visit;
    }

    public void setVisit(boolean[] visit) {
        this.visit = visit;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public int compareTo(Sangeun o) {
        return cost - o.cost;
    }
}