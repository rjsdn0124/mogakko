import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        String[] maze = new String[n];

        for(int i = 0; i < n; i++){
            maze[i] = br.readLine();
        }

        Queue<Where> que = new LinkedList<>(); 
        Where w = new Where(0,0,1);
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        Boolean[][] isVisit = new Boolean[n][m];
        for(int i = 0; i < n; i++){
            Arrays.fill(isVisit[i], false);
        }

        while(!(w.y == n - 1 && w.x == m - 1)){
            int x;
            int y;
            for(int i = 0 ; i < 4; i++){
                x = w.x + dx[i];
                y = w.y + dy[i];
                if((x < m && x >= 0) && (y < n && y >= 0)){
                    if(!isVisit[y][x] && maze[y].charAt(x) == '1'){
                        que.offer(new Where(x, y, w.time + 1));
                        isVisit[y][x] = true;
                    }
                }
            }
            w = que.poll();
        }
        System.out.println(w.time);
    }    
    static class Where{
        int x;
        int y;
        int time;
        public Where(int x, int y, int t){
            this.x = x;
            this.y = y;
            time = t;
        }
    }
}
