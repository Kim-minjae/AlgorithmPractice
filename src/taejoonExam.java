import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class taejoonExam {
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        StringTokenizer st;


        for(int t = 0; t<tc; t++){

            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            //인접해쉬맵
            HashMap<String, Integer> adjacentCost = new HashMap<>();
            //인접리스트
            ArrayList<Integer>[] adjacentList = new ArrayList[N+1];

            for(int i = 0; i<adjacentList.length; i++){
                adjacentList[i] = new ArrayList<>();
            }

            for(int i = 0; i<M; i++){
                st = new StringTokenizer(br.readLine());

                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                adjacentList[from].add(to);
                adjacentList[to].add(from);
                adjacentCost.put(from +" " +to, cost);
                adjacentCost.put(to +" " +from, cost);
            }

            //여행하고 싶은 두 행성정보
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int goal = Integer.parseInt(st.nextToken());

            PriorityQueue<SpaceShip> spaceShipQueue = new PriorityQueue<>();

            spaceShipQueue.add(new SpaceShip(start,K,0,new boolean[N+1]));

            while (!spaceShipQueue.isEmpty()){

                SpaceShip tmpSpaceShip = spaceShipQueue.poll();

                if(tmpSpaceShip.thisPlanet == goal){
                    System.out.println(tmpSpaceShip.timeCost);
                    break;
                }

                int from = tmpSpaceShip.thisPlanet;
                int tmpWarfCount = tmpSpaceShip.warfCount;
                int tmpTimeCost = tmpSpaceShip.timeCost;
                boolean[] tmpVisit = tmpSpaceShip.visit;

                //인접행성 확인
                for(int to : adjacentList[from]){

                    if(tmpVisit[to]) continue;

                    int timeCost = adjacentCost.get(from+" "+to);
                    boolean[] visit = tmpVisit.clone();
                    visit[from] = true;
                    //인접한행성으로 보내면서, 워프시켜서 하나보내고, 안 시키고 보내고, visit방문 시키고 ,코스트 추가시키고 해서 queue에 집어넣는다.
                    spaceShipQueue.offer(new SpaceShip(to,tmpWarfCount,tmpTimeCost+timeCost,visit));

                    if(tmpWarfCount >0){
                        spaceShipQueue.offer(new SpaceShip(to,tmpWarfCount-1,tmpTimeCost+1,visit));
                    }

                }

            }

        }

    }
    static class SpaceShip implements Comparable<SpaceShip>{

        int thisPlanet;
        int warfCount;
        int timeCost;
        boolean[] visit;

        public SpaceShip(int thisPlanet, int warfCount, int timeCost, boolean[] visit) {
            this.thisPlanet = thisPlanet;
            this.warfCount = warfCount;
            this.timeCost = timeCost;
            this.visit = visit;
        }

        @Override
        public int compareTo(SpaceShip o) {
            return this.timeCost - o.timeCost;
        }
    }
}
