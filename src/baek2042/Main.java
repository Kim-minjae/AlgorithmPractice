import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import static java.lang.Math.*;



/**
 * Created by pose2 on 6/8/2017.
 */
public class Main {

    static StringTokenizer st;
    static int[] arr_nodeNum;

    public static void main(String args[]) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());



        long arr[] = new long[N+1];
        arr_nodeNum = new int[N+1];

        for(int i = 1; i < N+1; i++){
            st = new StringTokenizer(br.readLine());

            arr[i] =  Integer.parseInt(st.nextToken());
        }

        int h = (int)ceil(log(N)/log(2));
        int tree_size = (int)pow(2,h+1);

        long tree[] = new long[tree_size+1];

        init(arr,tree,1,1,N);

        for(int i = 0; i<K+M; i++){
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());

            if(command == 1){

                int index = Integer.parseInt(st.nextToken());
                long tmp = arr[index];

                arr[index] = Integer.parseInt(st.nextToken());
                long diff = arr[index]-tmp;

                update(tree,arr_nodeNum[index],diff);

            }
            else if(command == 2){
                long result = sum(tree,1,Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),1,N);
                System.out.println(result);

            }
        }




    }
    public static long init(long[] arr_, long[] tree_, int node, int start, int end){
        if(start == end) {
            arr_nodeNum[start] = node;
            return tree_[node] = arr_[start];
        }

        int mid = (start + end) / 2;

        return tree_[node] = init(arr_,tree_,node*2,start,mid) + init(arr_,tree_,node*2 + 1,mid+1, end) ;
    }
    public static void update(long[] tree_, int index_, long diff){

        while(index_>0){
            tree_[index_] += diff;
            index_ = index_/2;
        }

    }
    public static long sum(long[] tree_, int node_, int left_, int right_, int start, int end){

        if(left_>end || right_<start){
            return 0;
        }

        if(left_<=start && end<=right_){
            return tree_[node_];
        }

        int mid_ = (start+end)/2;

        return sum(tree_,node_*2,left_,right_,start,mid_) + sum(tree_,node_*2+1,left_,right_,mid_+1,end);
    }
}

