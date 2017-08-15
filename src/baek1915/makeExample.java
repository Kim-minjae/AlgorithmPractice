import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * Created by pose2 on 2017-08-15.
 */
public class makeExample {
    int n;
    int m;
    int[][] map;

    public makeExample() {
        this.n = (int)(Math.random()*1000+1);
        this.m = (int)(Math.random()*1000+1);
        this.map = new int[n][m];
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int[][] getMap() {
        return map;
    }

    public void setMap() {

        for(int i =0 ; i< map.length; i++){
            for(int j = 0; j<map[0].length; j++){
                map[i][j] = (int)(Math.random()*2);
            }
        }
    }
    public void setMap(int x){
        for(int i =0 ; i< map.length; i++){
            for(int j = 0; j<map[0].length; j++){
                map[i][j] = x;
            }
        }
    }
    public void viewMap(){
        for(int i = 0; i< m; i++){
            System.out.println();
            for(int j = 0; j<n; j++){
                System.out.print(map[j][i] + " ");
            }
        }
    }
}
