package baek1158;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


class Main2{

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<Integer>();

        StringBuilder sb = new StringBuilder("<");
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken()) - 1;

        for(int i=1;i<=n;i++) list.add(i);

        int index = 0;

        while(!list.isEmpty()) {
            index += m;
            if (index >= list.size()) {
                index %= list.size();
            }
            System.out.println(list.size());
            sb.append(list.remove(index) + ", ");
        }

        System.out.println(sb.toString().substring(0, sb.length()-2) + ">");
    }
}