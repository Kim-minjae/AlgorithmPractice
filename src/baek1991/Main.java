package baek1991;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by pose2 on 2017-09-12.
 */
public class Main {
    public static void main(String args[])throws IOException{

        Node[] nodes = new Node[26];

        for(int i = 0; i<26; i++){
            nodes[i] = new Node(i,null,null);
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int root = (int)(st.nextToken().charAt(0) - 'A');

            int left = (int)(st.nextToken().charAt(0) - 'A');
            int right = (int)(st.nextToken().charAt(0) - 'A');

            if(left != '.'-'A'){
                nodes[root].left = nodes[left];
            }
            if(right != '.'-'A'){
                nodes[root].right = nodes[right];
            }
        }
        preorder(nodes[0]);
        System.out.println();
        middleorder(nodes[0]);
        System.out.println();
        postorder(nodes[0]);

    }
    public static void preorder(Node tmp){
        if(tmp!=null) {
            System.out.print((char) (tmp.index + 'A'));
            preorder(tmp.left);
            preorder(tmp.right);
        }
    }

    public static void middleorder(Node tmp){
        if(tmp!=null) {
            middleorder(tmp.left);
            System.out.print((char) (tmp.index + 'A'));
            middleorder(tmp.right);
        }
    }
    public static void postorder(Node tmp){
        if(tmp!=null) {
            postorder(tmp.left);
            postorder(tmp.right);
            System.out.print((char) (tmp.index + 'A'));
        }
    }

}
class Node{
    int index;
    Node left;
    Node right;

    public Node(int index, Node left, Node right) {
        this.index = index;
        this.left = left;
        this.right = right;
    }

}