package baek1922;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by pose2 on 2017-09-14.
 */
public class Kruskal2 {static int vertax;
    static int lineCount;
    static int[] parent; //cycle�� �˻��ϱ� ���� �ֻ��� �θ�� �����Ѵ�.
    static PriorityQueue<Edge> q = new  PriorityQueue<Edge>();
    public static void read(){
        Scanner sc = new Scanner(System.in);
        vertax = sc.nextInt();
        lineCount = sc.nextInt();
        parent = new int[vertax+1];
        for(int i=1; i<=vertax; i++){
            parent[i] = i; //�ڽ��� �ڽ��� �θ�� �����Ѵ�. ����Ŭ�˻翡 �ʿ�
        }
        for(int i=1; i<=lineCount; i++){
            Edge a = new Edge(sc.nextInt(),sc.nextInt(),sc.nextInt());//������,����,����ġ
            q.offer(a); //�켱���� ť�� �ְ� ���߿� �������� ����ġ�� �����ϱ�����
        }
    }

    //�������� �ֻ��� �θ� ã�Ƽ� return
    static int find(int vertax){
        if(vertax == parent[vertax]) return vertax;
        parent[vertax] = find(parent[vertax]);
        return parent[vertax];
    }

    static void union(int v1, int v2){
        int p1 = find(v1);
        int p2 = find(v2);
        if(p1!=p2) parent[p1] = p2; //�θ� �ٸ��� ��ģ��.��, ����Ŭ�� �ƴϴ�.
    }

    public static void process(){
        int sum=0;
        for(int i=1; i<=lineCount; i++){ //q�� ������ ����, q�� ������ ������ ������ŭ
            Edge edge = q.poll();
            //����Ŭ���� �˻��� ����Ŭ�� �ƴ϶�� �����Ѵ�.
            int p1 = find(edge.start);//���������� �θ� ã�´�.
            int p2 = find(edge.end);//�������� �θ� ã�´�.
            if(p1==p2) continue;//�θ� ���ٸ� ����Ŭ�̹Ƿ� ���������ʴ´�..������������
            union(edge.start, edge.end); //�θ� ���� �����д�.(���� �κ������� �ǵ���)
            sum += edge.weight;
        }
        System.out.println(sum);
    }


    static class Edge  implements Comparable<Edge>{
        int start;
        int end;
        int weight;
        public Edge(int start, int end, int weight) {
            super();
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge o) {
            // TODO Auto-generated method stub
            return weight - o.weight;


        }



    }

    public static void main(String[] args) {
        read();
        process();
    }

}
