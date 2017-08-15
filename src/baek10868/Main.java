import java.util.*;
import java.io.*;
import java.math.*;

public class Main{
    static BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw =
            new BufferedWriter(new OutputStreamWriter(System.out));

    static int n, p, L, R, i, len = 1;
    static long[] tree;

    public static void main(String args[]) throws IOException{
        // Scanner sc = new Scanner(System.in);
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        int[] A = new int[n+1]; // A라인에서 현재 위치에 있는 기계의 번호
        st = new StringTokenizer(br.readLine(), " ");
        for(i = 1; i <= n; i++) A[i] = Integer.parseInt(st.nextToken());
        int[] B = new int[1000001]; // 현재 번호의 기계의 B라인에서의 위치
        st = new StringTokenizer(br.readLine(), " ");
        for(i = 1; i <= n; i++) B[Integer.parseInt(st.nextToken())] = i;
        while(n*2 > len) len *= 2;
        tree = new long[len];
        long sum = 0;
        for(i = 1; i <= n; i++){
            p = B[A[i]];
            L = p+1;
            R = n;
            sum += segSum(1, 1, len/2);
            segUpdate(p);
        }
        bw.write(sum+"");
        bw.close();
    }

    static long segSum(int NNum, int nodeL, int nodeR){
        if(R < nodeL || nodeR < L) return 0;
        if(L <= nodeL && nodeR <= R) return tree[NNum];
        int mid = (nodeL + nodeR)/2;
        return segSum(NNum*2, nodeL, mid)+segSum(NNum*2+1, mid+1, nodeR);
    }

    static void segUpdate(int NNum){
        NNum += len/2-1;
        tree[NNum] = 1;
        while(NNum > 1){
            NNum /= 2;
            tree[NNum] = tree[NNum*2] + tree[NNum*2+1];
        }
    }

}

