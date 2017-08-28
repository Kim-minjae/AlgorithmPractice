    package baek1697;

    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.Arrays;
    import java.util.LinkedList;
    import java.util.Queue;
    import java.util.StringTokenizer;

    /**
     * Created by pose2 on 2017-08-28.
     */
    public class Main {

        static int[] map = new int[400000];

        public static void main(String args[])throws IOException{

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            Queue<Integer> q = new LinkedList<>();
            Queue<Integer> q2 = new LinkedList<>();


            Arrays.fill(map,Integer.MAX_VALUE);

            q2.offer(N);
            int count = 0;

            while (true){

                    while (!q2.isEmpty()){
                        q.offer(q2.poll());
                    }


                while ( (!q.isEmpty()) ){

                    int tmp = q.poll();
                    if (tmp <= 100000 && tmp>=0) {


                        if (map[tmp] > count) {
                            map[tmp] = count;
                            if (tmp == K) {
                                System.out.println(count);
                                return;
                            }

                            q2.offer(tmp - 1);
                            q2.offer(tmp + 1);
                            q2.offer(tmp * 2);

                        }
                    }
                }

                count++;

            }

        }
    }
