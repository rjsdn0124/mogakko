import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int stunum = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        Queue<Integer>[] que = new Queue[21];
        for(int i = 0; i < 21; i++){
            que[i] = new LinkedList<>();
        }

        long count = 0;
        for(int i = 0; i < stunum; i++){
            int tmp = br.readLine().length();
            if(que[tmp].isEmpty()){
                que[tmp].offer(i);
                continue;
            }
                while(i - que[tmp].peek() > k){
                    que[tmp].poll();
                    if(que[tmp].isEmpty()){
                        break;
                    }
                }
            count += que[tmp].size();
            que[tmp].offer(i);
        }
        System.out.println(count);
    }
}