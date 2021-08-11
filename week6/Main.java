import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int start = Integer.parseInt(input[0]);
        int goal = Integer.parseInt(input[1]);
        Queue<Info> que = new LinkedList<>();

        Info tmp = new Info(start, 0);
        Boolean[] isVisit = new Boolean[100001];
        Arrays.fill(isVisit,false);
        while(tmp.locate != goal){
                if(tmp.locate >= 1 && !isVisit[tmp.locate - 1]){
                    que.offer(new Info(tmp.locate - 1, tmp.time + 1));
                    isVisit[tmp.locate - 1] = true;
                }
                if(tmp.locate < 100000 && !isVisit[tmp.locate + 1]){
                    que.offer(new Info(tmp.locate + 1, tmp.time + 1));
                    isVisit[tmp.locate + 1] = true;
                }
                if(tmp.locate <= 50000 && !isVisit[tmp.locate * 2]){
                    que.offer(new Info(tmp.locate * 2, tmp.time + 1));
                    isVisit[tmp.locate * 2] = true;
                }
            tmp = que.poll();
        }
        System.out.println(tmp.time);
    }    
    static class Info{
        int locate;
        int time;
        public Info(int l, int t){
            locate = l;
            time = t;
        }
    }
}