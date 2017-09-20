    package baek1967;

    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.ArrayList;
    import java.util.StringTokenizer;

    /**
     * Created by pose2 on 2017-09-12.
     */
    public class Main {

        static Node[] nodes = new Node[10001];
        static int maxsum;

        public static void main(String args[])throws IOException{

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            maxsum =0;
            for(int i = 0; i<n-1; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());

                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                if(nodes[parent] == null){
                    nodes[parent] = new Node(0,0,new ArrayList<Node>());
                }if(nodes[child] == null){
                    nodes[child] = new Node(0,0,new ArrayList<Node>());
                }

                nodes[parent].index = parent;
                nodes[child].index = child;
                nodes[parent].babies.add(nodes[child]);
                nodes[child].weight = cost;
            }

            maxCost(nodes[1]);

            System.out.println(maxsum);

        }
        public static int maxCost(Node a){

            int sum = 0;
            int max = 0;
            if(a.babies.size() == 0){
                maxsum = Math.max(a.weight,maxsum);
                return a.weight;
            }
            for(int i = 0; i<a.babies.size(); i++){
                int tmpq = maxCost(nodes[a.babies.get(i).index]);
                sum += tmpq;
                max = Math.max(tmpq,max);
            }

            maxsum = Math.max(sum,maxsum);
            return a.weight  =  a.weight+max;
        }
    }
    class Node{
        int weight;
        int index;
        ArrayList<Node> babies;

        public Node( int weight, int index, ArrayList<Node> babies) {
            this.weight = weight;
            this.index = index;
            this.babies = babies;
        }
    }
