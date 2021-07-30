import java.io.*;
import java.util.*;

public class RGB{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int home = Integer.parseInt(br.readLine());
        int[][] cost = new int[home][3];
        for(int i = 0; i < home; i++){
            String[] tmp = br.readLine().split(" ");
            int[] eachCost = new int[3];
            for(int j = 0; j < 3; j++){
                eachCost[j] = Integer.parseInt(tmp[j]);
            }
            if(i != 0){
                eachCost[0] += cost[i - 1][1] < cost[i - 1][2]? cost[i - 1][1]:cost[i-1][2];
                eachCost[1] += cost[i - 1][0] < cost[i - 1][2]? cost[i - 1][0]:cost[i-1][2];
                eachCost[2] += cost[i - 1][0] < cost[i - 1][1]? cost[i - 1][0]:cost[i-1][1];
            }
            cost[i] = eachCost;
        }
        int min = cost[home - 1][0] < cost[home - 1][1] ? cost[home - 1][0]:cost[home-1][1];
        System.out.println(min < cost[home - 1][2] ? min : cost[home - 1][2]);
    }
}