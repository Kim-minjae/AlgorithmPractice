package estsoftCodility1;

import java.io.IOException;
import java.util.*;

/**
 * Created by pose2 on 2018-01-10.
 */

class MyCom implements Comparator<MyPhotos> {

    @Override
    public int compare(MyPhotos o1, MyPhotos o2) {
        return o1.index - o2.index;
    }

}

class MyPhotos implements Comparable<MyPhotos> {
    int index;
    String ext;
    String city;
    String date;
    int sortidx;

    public MyPhotos(int idx, String ext, String city, String date) {
        super();
        this.index = idx;
        this.ext = ext;
        this.city = city;
        this.date = date;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("MyPhotos [index=").append(index).append(", ext=").append(ext).append(", city=").append(city)
                .append(", date=").append(date).append(", sortidx=").append(sortidx).append("]");
        return builder.toString();
    }

    @Override
    public int compareTo(MyPhotos o) {
        if (this.city.equals(o.city))
            return this.date.compareTo(o.date);
        return this.city.compareTo(o.city);
    }
}

public class Solution {

    public static void main(String args[]) throws IOException{
        Solution a = new Solution();

        String tmps = "photo.jpg, Warsaw, 2013-09-05 14:08:15\n" +
                "john.png, London, 2015-06-20 15:13:22\n" +
                "myFriends.png, Warsaw, 2013-09-05 14:07:13\n" +
                "Eiffel.jpg, Paris, 2015-07-23 08:03:02\n" +
                "pisatower.jpg, Paris, 2015-07-22 23:59:59\n" +
                "BOB.jpg, London, 2015-08-05 00:02:03\n" +
                "notredame.png, Paris, 2015-09-01 12:00:00\n" +
                "me.jpg, Warsaw, 2013-09-06 15:40:22\n" +
                "a.png, Warsaw, 2016-02-13 13:33:50\n" +
                "b.jpg, Warsaw, 2016-01-02 15:12:22\n" +
                "c.jpg, Warsaw, 2016-01-02 14:34:30\n" +
                "d.jpg, Warsaw, 2016-01-02 15:15:01\n" +
                "e.png, Warsaw, 2016-01-02 09:49:09\n" +
                "f.png, Warsaw, 2016-01-02 10:55:32\n" +
                "g.jpg, Warsaw, 2016-02-29 22:13:11";

        System.out.println(a.solution(tmps));
    }

    public String solution(String s) throws IOException {
        StringTokenizer st= new StringTokenizer(s,"\n");
        String line = "";
        ArrayList<MyPhotos> strlist = new ArrayList<>();
        int i = 0;
        while (st.hasMoreTokens()) {
            line = st.nextToken();
            if (line == null)
                break;
            String[] tmp = line.split(",");
            if (tmp[0].substring(tmp[0].length() - 4).equalsIgnoreCase("jpeg")) {
                strlist.add(new MyPhotos(i++, tmp[0].substring(tmp[0].length() - 5), tmp[1].trim(), tmp[2]));
            } else {
                strlist.add(new MyPhotos(i++, tmp[0].substring(tmp[0].length() - 4), tmp[1].trim(), tmp[2]));
            }
        }
        Collections.sort(strlist);
        String cityname = strlist.get(0).city;
        int count = 1;
        Map<String, Integer> maxVal = new HashMap<>();
        for (int k = 0; k < strlist.size(); k++) {
            if (strlist.get(k).city.equals(cityname)) {
                strlist.get(k).sortidx = count++;
            } else {
                maxVal.put(cityname, count - 1);
                cityname = strlist.get(k).city;
                count = 1;
                strlist.get(k).sortidx = count++;
            }
            if (k == strlist.size() - 1) {
                maxVal.put(cityname, count - 1);
            }
        }

        Collections.sort(strlist, new MyCom());
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < strlist.size(); k++) {
            String a = Integer.toString(maxVal.get(strlist.get(k).city));
            int b = a.length();
            sb.append(strlist.get(k).city);
            int c = Integer.toString(strlist.get(k).sortidx).length();
            if (b != c) {
                int tmpp = b - c;
                while (tmpp-- != 0) {
                    sb.append(0);
                }
            }
            sb.append(strlist.get(k).sortidx).append(strlist.get(k).ext).append("\n");
        }
        String answer = sb.toString();


        return answer;

    }

}