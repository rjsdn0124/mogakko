import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[][] time = new int[num][2];

        for(int i = 0; i < num; i++){
            String[] str = br.readLine().split(" ");
            time[i][0] = Integer.parseInt(str[0]);
            time[i][1] = Integer.parseInt(str[1]);
        }
        Arrays.sort(time, new Comparator<int[]>(){
            public int compare(int[] a1, int[] a2){
                if(a1[1] == a2[1]){
                    return a1[0] - a2[0];
                }
                return a1[1] - a2[1];
            }
        });

        int result = 1;
        int[] arr = time[0];
        for(int i = 1; i < num; i++){
            if(arr[1] <= time[i][0]){
                arr = time[i];
                result++;
            }
        }
        System.out.println(result);
    }    
}
