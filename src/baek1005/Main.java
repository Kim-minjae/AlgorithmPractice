package baek1005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by pose2 on 5/10/2017.
 */
public class Main {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int T = Integer.parseInt(st.nextToken());

        for(int k = 0; k<T; k++){

            st = new StringTokenizer(br.readLine()," ");

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());




            int[] buildingCost = new int[N+1];
            boolean[][] adjacent = new boolean[N+1][N+1]; //인접행렬
            int[] trunkCount = new int[N+1];
            int tmp1,tmp2 = 0;

            st = new StringTokenizer(br.readLine()," ");

            for(int i = 1; i<N+1; i++){
                buildingCost[i] = Integer.parseInt(st.nextToken());
            }

            int[] totalCost = Arrays.copyOf(buildingCost,buildingCost.length);

            for(int i = 0; i<K; i++){

                st = new StringTokenizer(br.readLine());
                tmp1 = Integer.parseInt(st.nextToken());
                tmp2 = Integer.parseInt(st.nextToken());
                adjacent[tmp1][tmp2] = true;

                trunkCount[tmp2]++; // 간선 갯수 확보

            }

            st = new StringTokenizer(br.readLine());

            int goal = Integer.parseInt(st.nextToken());


            Queue<Integer> searchQ = new LinkedList<Integer>();
            Queue<Integer> resultQ = new LinkedList<Integer>();

            //들어오는 간선의 갯수가 0인것들 찾아서 넣기. (초기화)


            while(true){

                //들어오는 간선의 갯수가 0인것들 찾아서 넣기.
                for(int i =1; i<N+1; i++){
                    if(trunkCount[i] == 0){
                        searchQ.offer(i);
                        trunkCount[i]--;
                    }
                }

               if(searchQ.peek() == goal){
                break;
               } // 목표노드 전까지만 위상정렬해도 괜찮다

                tmp1 = searchQ.poll();

                for(int i = 1; i<N+1; i++){
                    if(adjacent[tmp1][i]){
                        trunkCount[i]--;
                    }
                }

                resultQ.offer(tmp1);

            }

            while (!resultQ.isEmpty()){
                tmp1 = resultQ.poll();

                for(int i = 1; i<N+1; i++){
                    if(adjacent[tmp1][i]){
                        totalCost[i] = (totalCost[i]<(buildingCost[i] + totalCost[tmp1]))
                                ?(buildingCost[i] + totalCost[tmp1]):totalCost[i];
                    }
                }

            }

            System.out.println(totalCost[goal]);

        }

    }
}