package baek10815;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by pose2 on 2017-09-08.
 */
public class Main {
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Node> queueSangeun = new PriorityQueue<>();
        PriorityQueue<Node> queueMe = new PriorityQueue<>();


        int M = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<M; i++){
             queueMe.offer(new Node(Integer.parseInt(st.nextToken()),0));
        }

        int N = Integer.parseInt(br.readLine());

        int[] arrayN = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i<N; i++){
            queueSangeun.offer(new Node(Integer.parseInt(st.nextToken()),i));
        }

        Node tmpNodeMe;
        Node tmpNodeSangeun;
        LoopA : while (!queueMe.isEmpty()){
            tmpNodeMe = queueMe.poll();
            while (!queueSangeun.isEmpty()){
                tmpNodeSangeun = queueSangeun.poll();
                while (tmpNodeMe.value>tmpNodeSangeun.value){
                       tmpNodeSangeun = queueSangeun.poll();
                }
                if(tmpNodeMe.value == tmpNodeSangeun.value){
                    arrayN[tmpNodeSangeun.index] = 1;
                    continue LoopA;
                }else {
                    queueSangeun.offer(tmpNodeSangeun);
                    continue LoopA;
                }
            }

        }

        StringBuffer tmp = new StringBuffer("");
        for(int i = 0; i<arrayN.length-1; i++){
            tmp.append(arrayN[i]+" ");
        }
        tmp.append(arrayN[arrayN.length-1]);
        System.out.println(tmp);
    }
}
class Node implements Comparable<Node>{
    int value;
    int index;

    public Node(int value, int index) {
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(Node o) {
        return value - o.value;
    }
}
