package baek2252;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by pose2 on 2017-05-12.
 */
public class Main {



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");


        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int vertex1,vertex2,tmp;

        int[] trunkCount = new int[N+1]; // 차수 행렬

        ArrayList<ArrayList<Integer>> adList = new <ArrayList<Integer>> ArrayList();

        for(int i = 0; i<N+1; i++){
            adList.add(new<Integer> ArrayList());
        }

        for(int i = 0; i<M; i++){

            st = new StringTokenizer(br.readLine(), " ");

            vertex1 = Integer.parseInt(st.nextToken());
            vertex2 = Integer.parseInt(st.nextToken());


            adList.get(vertex1).add(vertex2);
            trunkCount[vertex2]++;
        }

        Queue<Integer> searchQ = new LinkedList<>();
        Queue<Integer> resultQ = new LinkedList<>();

        while(!searchQ.isEmpty()){

            //들어오는 간선의 갯수가 0인것들 찾아서 넣기.
            for(int i =1; i<N+1; i++){
                if(trunkCount[i] == 0){
                    searchQ.offer(i);
                    trunkCount[i]--;
                }
            }

            tmp = searchQ.poll();

            for(int i = 0; i<adList.get(tmp).size(); i++){

                    trunkCount[i]--;

            }

            resultQ.offer(tmp);

        }

        while (!resultQ.isEmpty()){
            tmp = resultQ.poll();

            System.out.println(tmp + " ");

        }

    }
}
