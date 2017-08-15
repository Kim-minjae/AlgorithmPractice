package baek4195;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by pose2 on 2017-08-12.
 */
public class Main {
    public static void main(String args[]) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int tc = 0; tc<T; tc++){

            st = new StringTokenizer(br.readLine());
            int F = Integer.parseInt(st.nextToken());

            int fCount = 0;// 친구 번호부여
            HashMap<String,FNode> friends = new HashMap<>();
            int[] fsum = new int[200000]; // 조상번호에 따른 친구합을 저장하는 공간.
            Arrays.fill(fsum,1);


            for(int i = 0; i<F; i++){


                st = new StringTokenizer(br.readLine());

                String tmp1 = st.nextToken();
                String tmp2 = st.nextToken();

                FNode fNode1 = null;
                FNode fNode2 = null;


                //있는놈이면 빼다가 쓰고 없는놈이면 객체생성하고 해쉬맵에 넣어준다.
                //처음들어오는 놈이면 자기자신이 조상이다.
                if(friends.containsKey(tmp1)){
                    fNode1 = friends.remove(tmp1);
                }else {
                    fNode1 = new FNode(tmp1,fCount,fCount++);
                }

                if(friends.containsKey(tmp2)){
                    fNode2 = friends.remove(tmp2);
                }else {
                    fNode2 = new FNode(tmp2,fCount,fCount++);
                }

                //친구관계로 조상서열정리 해주기 .

                if(fNode1.getAncester().equals(fNode2.getAncester())) {
                    //만약 이미 조상이 같으면 연결할 필요 없다.
                }else {
                    //fsum[조상번호1] 에 fsum[조상번호2]의 크기를 더해준다.
                    fsum[fNode1.getAncester()] += fsum[fNode2.getAncester()];

                    //친구 2의 조상을 친구 1의 조상과 같게 만들어준다.
                    fNode2.setAncester(fNode1.getAncester());
                }
                friends.put(tmp1, fNode1);
                friends.put(tmp2, fNode2);

                System.out.println(fsum[fNode1.getAncester()]);

            }

        }

    }
}
class FNode{
    String name;
    int nodeNum;
    Integer ancester;

    public FNode(String name, int nodeNum, Integer ancester) {
        this.name = name;
        this.nodeNum = nodeNum;
        this.ancester = ancester;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNodeNum() {
        return nodeNum;
    }

    public void setNodeNum(int nodeNum) {
        this.nodeNum = nodeNum;
    }

    public Integer getAncester() {
        return ancester;
    }

    public void setAncester(Integer ancester) {
        this.ancester = ancester;
    }

}
