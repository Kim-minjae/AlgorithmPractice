package baek1389;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by pose2 on 2017-07-29.
 */
public class Main {

    static int[][] adjacent;
    static int N;

    public static void main(String args[]) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //인접행렬 초기화
        adjacent = new int[N+1][N+1];

        //Node 객체 생성하고 배열에 넣어놓기
        Node[] Nodes = new Node[N+1];


        //노드배열을 만들어서 모든 vertex를 시작점으로 한 노드들로 BFS시킬거기때문에 미리 만들어놓음.
        //또 이렇게 해둬야 시작할때 바로 인접한 애들을 for문으로 찾지않고 입력을 받으면서 동시에 직접 인접한 vertex들을 nextVertex에 저장시켜놓을 수 있음.
        for(int i = 1; i<N+1; i++){
            Nodes[i] = new Node(i,N);
        }


        //인접행렬을 만들면서 양방향성 이므로 양쪽에 둘다 체크를 해주고 nextVertex큐에 최인접들을 집어넣어줌.
        //친구관계가 중복되서 나오면 최인접 vertex들을 nextVertex큐에 두번 넣어줄 수 있으니 이미 한번 확인된친구관계인지 if문으로 확인해줌
        for(int i =0; i<M; i ++){
            st = new StringTokenizer(br.readLine());

            int tmpX = Integer.parseInt(st.nextToken());
            int tmpY = Integer.parseInt(st.nextToken());

            if(adjacent[tmpX][tmpY] != 1) {
                Nodes[tmpX].addNextVertex(tmpY);
                Nodes[tmpY].addNextVertex(tmpX);
            }

            adjacent[tmpX][tmpY] = 1;
            adjacent[tmpY][tmpX] = 1;


        }

        //pq에 모든 노드를 넣고 startPoint의 크리과 cost로 비교해서 정렬한다.
        ArrayList<Node> priorityQueue = new ArrayList<>();


        //pq에 모든 vertex출발점 ( cost는 0임) 을 넣고 경쟁시킨다.
        for(int i = 1; i<N+1; i++){
            Nodes[i].setVisit(i);
            priorityQueue.add(Nodes[i]);
        }
        NodeComparator sort = new NodeComparator();
        //while 문 시작
        while (!priorityQueue.isEmpty()){

            Node tmpNode = priorityQueue.remove(0);

            //nextVertex가 비었는지 안비었는지 확인을 한다., 만약 비었다면, 모든 노드를 정복했다는 뜻이므로 pq에서 맨처음이고 모든 노드를 정복했으면
            //정답이므로 startPoint를 출력한다.
            if(tmpNode.NodeQisEmpty()){
                System.out.println(tmpNode.startPoint);
                return;
            }
            //tmpQ에다가 nextVertex(정수값) 들을 받아놓는다.
            Queue<Integer> tmpQ = new LinkedList<>();

            //nextVertex는 가장끝단의 vertex들과 인접해있는 vertex들을 저장하고있는 큐 이다. 이 큐가 빌때까지 빼면서 방문하고 방문한 cost를 Node 객체의 cost에 더한다.
            while (!tmpNode.nextVertex.isEmpty()){

                int k = tmpNode.nextVertex.poll();
                tmpNode.setVisit(k);

                tmpQ.offer(k);
                tmpNode.setCost(tmpNode.getCost()+tmpNode.getCount());
            }

            //n번째 Node를 호출했다면 n번만에 도달할 수 있는 모든 vertex를 방문했고 cost를 더했으므로 count를 올려서 n+1번만에 갈 수 있는 vertex들을 탐색할때 사용할 수 있게한다.
            tmpNode.setCount(tmpNode.getCount()+1);

            //방문한적도 없으며 최외곽 vertex와 맞닿아있는vertex들을 찾아서 nextVertex큐에 집어넣는다.
            boolean[] tmpVisit = tmpNode.getVisit();
            boolean[] tmpVisit2 = new boolean[N+1];
            while (!tmpQ.isEmpty()){
                int tmpVertex = tmpQ.poll();
                for(int i = 1; i<N+1; i++) {
                    if (!tmpVisit[i] && adjacent[tmpVertex][i] == 1){
                        if(!tmpVisit2[i]) {
                            tmpNode.addNextVertex(i);
                            tmpVisit2[i] = true;
                        }
                    }
                }
            }

            priorityQueue.add(tmpNode);
            Collections.sort(priorityQueue,sort);
        }



    }
}
class Node {
    int startPoint;
    private int count;
    private int cost;
    private boolean[] visit;
    Queue<Integer> nextVertex;

    public Node(int startPoint, int N) {
        this.startPoint = startPoint;
        this.count = 1;
        this.cost = 0;
        this.visit = new boolean[N+1];
        visit[0] = true;
        this.nextVertex = new LinkedList<>();
    }
    public boolean NodeQisEmpty(){
        if(nextVertex.isEmpty()){
            return true;
        }
        return false;
    }

    public void addNextVertex(int i){
        nextVertex.offer(i);
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public boolean[] getVisit() {
        return visit;
    }

    public void setVisit(int i) {
        this.visit[i] = true;
    }



}
class NodeComparator implements Comparator<Node>{
    @Override
    public int compare(Node o1, Node o2) {
        if(o1.getCost() != o2.getCost()){
            return o1.getCost()-o2.getCost();
        }else {
            return o1.startPoint-o2.startPoint;
        }
    }
}
